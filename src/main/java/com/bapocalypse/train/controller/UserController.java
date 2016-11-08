package com.bapocalypse.train.controller;

import com.alibaba.fastjson.JSONObject;
import com.bapocalypse.train.model.Image;
import com.bapocalypse.train.model.ImageResult;
import com.bapocalypse.train.model.User;
import com.bapocalypse.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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
            produces = "application/json;charset=UTF-8")
    public @ResponseBody String getUser(@PathVariable("uid") Integer uid) throws Exception {
        JSONObject userJson = new JSONObject();
        User user = userService.findUserByUid(uid);
        userJson.put("user",user);
        return userJson.toJSONString();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String createUser(@Valid User user, BindingResult bindingResult,
                                           HttpServletResponse response)throws Exception{
        String error = "";
        boolean result = false;
        JSONObject userJson = new JSONObject();
        if (bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError e : allErrors) {
                error = String.join(";", e.getDefaultMessage());
            }
        } else {
            result = userService.insertUser(user);
            response.setHeader("Location", "/user/" + user.getUid());
        }
        userJson.put("result", result);
        userJson.put("error", error);
        return userJson.toJSONString();
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

    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public @ResponseBody String loginUser(String username, String password) throws Exception {
        JSONObject loginJson = new JSONObject();
        ImageResult ir = Image.generateImage();
        boolean result = userService.loginUser(username, password);
        loginJson.put("result", result);
        loginJson.put("file", ir.getName());
        loginJson.put("tip", ir.getTip());
        System.out.println(loginJson.toJSONString());
        return loginJson.toJSONString();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
