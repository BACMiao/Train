package com.bapocalypse.train.controller;

import com.alibaba.fastjson.JSONObject;
import com.bapocalypse.train.model.DistanceCustom;
import com.bapocalypse.train.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @package: com.bapocalypse.train.controller
 * @Author: 陈淼
 * @Date: 2016/11/20
 * @Description: 距离的控制器类
 */
@Controller
@RequestMapping("/distance")
public class DistanceController {
    private DistanceService distanceService;

    @RequestMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    String getAllDistances() throws Exception {
        JSONObject distanceJson = new JSONObject();
        List<DistanceCustom> distanceCustoms = distanceService.findAllDistance();
        distanceJson.put("distances", distanceCustoms);
        return distanceJson.toJSONString();
    }

    @Autowired
    public void setDistanceService(DistanceService distanceService) {
        this.distanceService = distanceService;
    }
}
