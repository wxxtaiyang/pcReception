package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAccount;
import com.cykj.bean.PcUser;
import com.cykj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/query")
    public String queryAcountById(HttpSession session) {
        PcUser user = (PcUser) session.getAttribute("user");
        return accountService.queryAccountByUserId(user.getUserid()).toString();
    }

    @RequestMapping("/insert")
    public String insertAccountByUserId(HttpSession session,double num){
        PcUser user = (PcUser) session.getAttribute("user");
        PcAccount account = new PcAccount(0,user.getUserid(),0,null,"充值",1,num);
        return accountService.insertAccontByUserId(session,account).toString();
    }
}
