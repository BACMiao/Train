package com.bapocalypse.train.controller;

import com.alibaba.fastjson.JSONObject;
import com.bapocalypse.train.dto.Exposer;
import com.bapocalypse.train.dto.TrickExecution;
import com.bapocalypse.train.enums.BuyTrickStateEnum;
import com.bapocalypse.train.exception.RepeatBuyException;
import com.bapocalypse.train.exception.TrickCloseException;
import com.bapocalypse.train.po.Trick;
import com.bapocalypse.train.service.TrickService;
import com.bapocalypse.train.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @package: com.bapocalypse.train.controller
 * @Author: 陈淼
 * @Date: 2016/11/29
 * @Description: 车票的控制器类
 */
@Controller
@RequestMapping("/trick")
public class TrickController {

    private TrickService trickService;

    @RequestMapping(value = "/{uid}/list",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    String list(@PathVariable("uid") Integer uid) {
        JSONObject trickJson = new JSONObject();
        //获取用户购买的所有车票
        List<Trick> trickList = trickService.findAllTricksByUid(uid);
        trickJson.put("trickList", trickList);
        return trickJson.toJSONString();
    }

    @RequestMapping(value = "/{tid}/{date}/exposer",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    String exposer(@PathVariable("tid") String tid, @PathVariable("date") String date) {
        JSONObject trickJson = new JSONObject();
        Exposer exposer = trickService.exportBuyTrickUrl(tid, DateUtil.strToDate(date));
        trickJson.put("exposer", exposer);
        return trickJson.toJSONString();
    }

    @RequestMapping(value = "/{trick}/{level}/{md5}/execute",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    String execute(@PathVariable("trick") Trick trick,
                   @PathVariable("level") String level,
                   @PathVariable("md5") String md5) {
        JSONObject executeJson = new JSONObject();
        try {
            TrickExecution execution = trickService.executeBuyTrick(trick, level, md5);
            executeJson.put("execution", execution);
        } catch (RepeatBuyException rbe) {
            TrickExecution execution = new TrickExecution(trick.getTid(), trick.getDate(), BuyTrickStateEnum.REPEAT_BUY);
            executeJson.put("execution", execution);
        } catch (TrickCloseException tce) {
            TrickExecution execution = new TrickExecution(trick.getTid(), trick.getDate(), BuyTrickStateEnum.END);
            executeJson.put("execution", execution);
        } catch (Exception e) {
            TrickExecution execution = new TrickExecution(trick.getTid(), trick.getDate(), BuyTrickStateEnum.INNER_ERROR);
            executeJson.put("execution", execution);
        }
        return executeJson.toJSONString();
    }

    @RequestMapping(value = "/time/now",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    String time() {
        JSONObject timeJson = new JSONObject();
        Date date = new Date();
        timeJson.put("time", date);
        return timeJson.toJSONString();
    }

    @Autowired
    public void setTrickService(TrickService trickService) {
        this.trickService = trickService;
    }
}
