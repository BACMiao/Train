package com.bapocalypse.train.controller;

import com.bapocalypse.train.model.User;
import com.bapocalypse.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @package: com.bapocalypse.train.controller
 * @Author: 陈淼
 * @Date: 2016/10/30
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @RequestMapping(value = "/usersView/{uid}",
            method = RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public ModelAndView getUser(@PathVariable("uid") Integer uid) throws Exception {
        User user = userService.findUserByUid(uid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        System.out.println(user.getName());
        return mv;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
