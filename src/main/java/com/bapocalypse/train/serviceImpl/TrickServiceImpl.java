package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.TrainDateDao;
import com.bapocalypse.train.dao.TrickDao;
import com.bapocalypse.train.dto.Exposer;
import com.bapocalypse.train.dto.TrickExecution;
import com.bapocalypse.train.enums.BuyTrickStateEnum;
import com.bapocalypse.train.exception.RepeatBuyException;
import com.bapocalypse.train.exception.TrickCloseException;
import com.bapocalypse.train.exception.TrickException;
import com.bapocalypse.train.po.TrainDate;
import com.bapocalypse.train.po.Trick;
import com.bapocalypse.train.service.TrickService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Date;
import java.util.List;

/**
 * @package: com.bapocalypse.train.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/11/25
 * @Description: 车票操作的服务接口实现类
 */
@Service
public class TrickServiceImpl implements TrickService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private TrickDao trickDao;
    private TrainDateDao trainDateDao;

    @Override
    public List<Trick> findAllTricksByUid(int uid) {
        return trickDao.findAllTricksByUid(uid);
    }

    @Override
    public Exposer exportBuyTrickUrl(String tid, Date date) {
        List<TrainDate> trainList = trainDateDao.findAllTrainsByDate(date);
        if (trainList.size() < 1) {
            return new Exposer(false, date);
        }
        int i = 0;
        do {
            if (trainList.get(i).getTid().equals(tid)) {
                break;
            }
            i++;
        } while (i <= trainList.size());

        //若i > trainList.size()，说明在当天列车列表中找不到指定列车
        if (i > trainList.size()) {
            return new Exposer(false, date);
        }
        Date nowDate = new Date(System.currentTimeMillis());
        if (nowDate.getTime() > date.getTime()) {
            return new Exposer(false, tid, date, nowDate.getTime());
        }
        String md5 = getMD5(tid, date);
        return new Exposer(true, md5, tid);
    }

    private String getMD5(String tid, Date date) {
        String salt = "jsdkajsklj1-02983848p][;/./wqjs]";
        String base = tid + "/" + date.toString() + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    @Override
    public TrickExecution executeBuyTrick(Trick trick, String level, String md5)
            throws TrickException, RepeatBuyException, TrickCloseException {
        if (md5 == null || !md5.equals(getMD5(trick.getTid(), trick.getDate()))) {
            throw new TrickException("buy trick date rewrite");
        }
        //执行购票逻辑，减票数+记录购买行为
        int updateCount;
        try {
            switch (level) {
                case "一等座": {
                    updateCount = trainDateDao.reduceFirstSeatNumber(trick.getTid(), trick.getDate());
                    break;
                }
                case "二等座": {
                    updateCount = trainDateDao.reduceSecondSeatNumber(trick.getTid(), trick.getDate());
                    break;
                }
                case "站票": {
                    updateCount = trainDateDao.reduceStandNumber(trick.getTid(), trick.getDate());
                    break;
                }
                default:
                    throw new TrickException("no trick");
            }
            if (updateCount <= 0) {
                //没有更新到记录，购票结束
                throw new TrickCloseException("trick is closed");
            } else {
                //记录购买行为
                int insertCount = trickDao.createTrick(trick);
                if (insertCount <= 0) {
                    //重复购买
                    throw new RepeatBuyException("buy repeat");
                } else {
                    //购买成功
                    Trick trick1 = trickDao.findTrickByPrimary(trick.getUid(), trick.getTid(), trick.getDate());
                    return new TrickExecution(trick1.getTid(), trick1.getDate(), BuyTrickStateEnum.SUCCESS, trick1);
                }
            }
        } catch (TrickCloseException | RepeatBuyException tce) {
            throw tce;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期异常转换为运行期异常
            throw new TrickException("buy trick inner error:" + e.getMessage());
        }
    }

    @Autowired
    public void setTrickDao(TrickDao trickDao) {
        this.trickDao = trickDao;
    }

    @Autowired
    public void setTrainDateDao(TrainDateDao trainDateDao) {
        this.trainDateDao = trainDateDao;
    }
}
