package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/vaguequery")
    public String vagueQuery(String name,long state,int page,int limit){
        JSONObject js = new JSONObject();
        js.put("data",userService.dimQueryUserByNameAndAcc(name,state,page,limit));
        js.put("count",userService.queryUserSizeByNameAndAcc(name,state));
        js.put("code",0);
        js.put("msg","");
        System.out.println(js.toString());
        return js.toString();
    }

    @RequestMapping("/updatestate")
    public String updateState(long userid){
        return userService.updateUserStateByUserId(userid).toString();
    }

    @RequestMapping("/resetpwd")
    public String resetUserPwd(long userid){
        return userService.resetUserPasswordByUserId(userid).toString();
    }

    @RequestMapping("/del")
    public String delUser(long userid){
        return userService.deleteUserByUserId(userid).toString();
    }

    @RequestMapping("/usercount")
    public String countUser(long type){
        return userService.countUserByType(type).toString();
    }
}
