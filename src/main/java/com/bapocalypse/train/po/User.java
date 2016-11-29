package com.bapocalypse.train.po;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @package: com.bapocalypse.train.po
 * @Author: 陈淼
 * @Date: 2016/10/28
 * @Description: 用户的模型类
 */
public class User {
    private int uid;
    @Size(min = 6, max = 30, message = "6-30位字母")
    @Pattern(regexp = "^[A-Za-z]+[A-Za-z0-9_]+$", message = "字母、数字或“_”,且字母开头")
    private String username; //用户名
    @Size(min = 6, max = 20, message = "密码必须为6-20位")
    private String password; //密码
    @NotNull(message="名字不能为空")
    private String name;     //真实姓名
    private int IDType;      //证件类型
    @Pattern(regexp = "[0-9]{17}+[0-9X]$", message = "请输入有效的证件号！")
    private String ID;       //证件号
    @Email(message = "请输入有效的电子邮件地址！")
    private String email;    //邮箱
    @NotNull(message = "手机号不能为空")
    private String telephone; //电话
    private int passenger; //乘客类型

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIDType() {
        return IDType;
    }

    public void setIDType(int IDType) {
        this.IDType = IDType;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }
}
