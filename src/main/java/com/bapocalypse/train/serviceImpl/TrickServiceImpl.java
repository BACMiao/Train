package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.TrainDateDao;
import com.bapocalypse.train.dao.TrickDao;
import com.bapocalypse.train.dto.Exporser;
import com.bapocalypse.train.dto.TrickExecution;
import com.bapocalypse.train.exception.RepeatBuyException;
import com.bapocalypse.train.exception.TrickCloseException;
import com.bapocalypse.train.exception.TrickException;
import com.bapocalypse.train.model.Train;
import com.bapocalypse.train.model.Trick;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private TrickDao trickDao;
    private TrainDateDao trainDateDao;
    //MD5盐值
    private final String salt = "jsdkajsklj1-02983848p][;/./wqjs]";

    @Override
    public Exporser exportBuyTrickUrl(String tid, Date date) {
        List<Train> trainList = trainDateDao.findAllTrainsByDate(date);
        if (trainList.size() < 1) {
            return new Exporser(false, date);
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
            return new Exporser(false, date);
        }
        Date nowDate = new Date(System.currentTimeMillis());
        if (nowDate.getTime() > date.getTime()) {
            return new Exporser(false, tid, date, nowDate.getTime());
        }
        String md5 = getMD5(tid, date);
        return new Exporser(true, md5, tid);
    }

    private String getMD5(String tid, Date date){
        String base = tid + "/" + date.toString() + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    @Override
    public TrickExecution executeBuyTrick(Trick trick, String md5) throws TrickException, RepeatBuyException, TrickCloseException {
        return null;
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
