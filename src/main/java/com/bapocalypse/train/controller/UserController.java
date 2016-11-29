package com.bapocalypse.train.controller;

import com.alibaba.fastjson.JSONObject;
import com.bapocalypse.train.po.Cache;
import com.bapocalypse.train.util.ImageUtil;
import com.bapocalypse.train.po.ImageResult;
import com.bapocalypse.train.po.User;
import com.bapocalypse.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

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
    public
    @ResponseBody
    String getUser(@PathVariable("uid") Integer uid) throws Exception {
        JSONObject userJson = new JSONObject();
        User user = userService.findUserByUid(uid);
        userJson.put("user", user);
        return userJson.toJSONString();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public
    @ResponseBody
    String createUser(@Valid User user, BindingResult bindingResult,
                      HttpServletResponse response) throws Exception {
        String error = "";
        boolean result = false;
        JSONObject userJson = new JSONObject();
        if (bindingResult.hasErrors()) {
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

    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    String loginUser(HttpServletRequest request,
                     String username,
                     String password,
                     String location) throws Exception {
        JSONObject loginJson = new JSONObject();
        Cookie[] cookies = request.getCookies();
        Cookie note = null;
        for (Cookie cookie : cookies) {
            if (Objects.equals(cookie.getName(), "note")) {
                note = cookie;
                break;
            }
        }
        boolean result = userService.loginUser(username, password);
        loginJson.put("result", result);
        if (!result) {
            return loginJson.toJSONString();
        }
        if (null == note) {
            loginJson.put("result", false);
        } else {
            ImageResult ir = Cache.get(note.getValue());
            Cache.remove(note.getName());
            if (null == location && "".equals(location)) {
                loginJson.put("result", false);
            }
            if (validate(location, ir)) {
                loginJson.put("result", true);
            } else {
                loginJson.put("result", false);
            }
        }
        System.out.println(loginJson.toJSONString());
        return loginJson.toJSONString();
    }

    @RequestMapping(value = "/identify", produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    String identify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject imageJson = new JSONObject();
        ImageResult ir = ImageUtil.generateImage(request);
        imageJson.put("file", ir.getName());
        imageJson.put("tip", ir.getTip());
        Cache.put(ir.getUniqueKey(), ir);
        Cookie cookie = new Cookie("note", ir.getUniqueKey());
        response.addCookie(cookie);
        return imageJson.toJSONString();
    }

    private boolean validate(String locationString, ImageResult ir) {
        String[] resultArray = locationString.split(";");
        if (resultArray.length != ir.getKeySet().size()) {
            return false;
        }
        int[][] array = new int[resultArray.length][2];
        for (int i = 0; i < resultArray.length; i++) {
            String[] temp = resultArray[i].split(",");
            array[i][0] = Integer.parseInt(temp[0]) + 150 - 10;
            array[i][1] = Integer.parseInt(temp[1]) + 300;
        }

        for (int i = 0; i < array.length; i++) {
            int location = location(array[i][1], array[i][0]);
            if (!ir.getKeySet().contains(location)) {
                return false;
            }
        }
        return true;
    }

    private static int location(int x, int y) {
        if (y >= 0 && y < 75) {
            return xLocation(x);
        } else if (y >= 75 && y <= 150) {
            return xLocation(x) + 4;
        } else {
            return -1;
        }
    }

    private static int xLocation(int x) {
        if (x >= 0 && x < 75) {
            return 0;
        } else if (x >= 75 && x < 150) {
            return 1;
        } else if (x >= 150 && x < 225) {
            return 2;
        } else if (x >= 225 && x <= 300) {
            return 3;
        } else {
            return -1;
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
