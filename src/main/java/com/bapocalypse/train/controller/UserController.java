package com.bapocalypse.train.controller;

import com.bapocalypse.train.model.User;
import com.bapocalypse.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @package: com.bapocalypse.train.controller
 * @Author: 陈淼
 * @Date: 2016/10/30
 * @Description: 用户的控制器类
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @RequestMapping(value = "/{uid}",
            method = RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public String getUser(@PathVariable("uid") Integer uid, Model model) throws Exception {
        User user = userService.findUserByUid(uid);
        model.addAttribute("user",user);
        System.out.println(user.getName());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(User user, HttpServletResponse response)throws Exception{
        userService.insertUser(user);
        response.setHeader("Location", "/user" + user.getUid());
        return "index";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
