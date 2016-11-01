package com.bapocalypse.train.controller;

import com.alibaba.fastjson.JSONObject;
import com.bapocalypse.train.model.User;
import com.bapocalypse.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody String getUser(@PathVariable("uid") Integer uid) throws Exception {
        JSONObject userJson = new JSONObject();
        User user = userService.findUserByUid(uid);
        userJson.put("user",user);
        System.out.println(userJson.toJSONString());
        return userJson.toJSONString();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(User user, HttpServletResponse response)throws Exception{
        userService.insertUser(user);
        response.setHeader("Location", "/user/" + user.getUid());
        return "index";
    }

    @RequestMapping(value = "/{uid}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateUser(@PathVariable("uid") int uid, User user) throws Exception {
        userService.updateUser(user);
        return "index";
    }

    @RequestMapping(value = "/{uid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUser(@PathVariable("uid") int uid) throws Exception {
        userService.deleteUserByUid(uid);
        return "index";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
