package com.bapocalypse.train.controller;

import com.alibaba.fastjson.JSONObject;
import com.bapocalypse.train.po.Trick;
import com.bapocalypse.train.service.TrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    public void setTrickService(TrickService trickService) {
        this.trickService = trickService;
    }
}
