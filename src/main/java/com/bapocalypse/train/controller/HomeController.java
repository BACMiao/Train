package com.bapocalypse.train.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @package: com.bapocalypse.train.controller
 * @Author: 陈淼
 * @Date: 2016/10/29
 * @Description:
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
