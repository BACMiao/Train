package com.bapocalypse.train.controller;

import com.alibaba.fastjson.JSONObject;
import com.bapocalypse.train.model.Station;
import com.bapocalypse.train.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @package: com.bapocalypse.train.controller
 * @Author: 陈淼
 * @Date: 2016/11/19
 * @Description: 车站的控制器类
 */
@Controller
@RequestMapping("/station")
public class StationController {
    private StationService stationService;

    @RequestMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    String getAllStations() throws Exception {
        JSONObject stationJson = new JSONObject();
        List<Station> stations = stationService.selectAllStations();
        stationJson.put("stations", stations);
        return stationJson.toJSONString();
    }

    @Autowired
    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }
}
