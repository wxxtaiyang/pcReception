package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcUser;
import com.cykj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String userLoginByAccAndPwd(HttpSession session, String useracc, String userpwd, String code){
        return userService.userLogin(session,useracc,userpwd,code).toString();
    }

    @RequestMapping("/register")
    public String userRegister(PcUser user){
        return userService.userRegister(user).toString();
    }

    @RequestMapping("/get")
    public String getUser(HttpSession session){
        PcUser user = (PcUser) session.getAttribute("user");
        return JSONObject.toJSONString(user);
    }
}
