package com.cykj.controller;

import com.cykj.bean.PcAdmin;
import com.cykj.service.AdminacpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/acpadmin")
public class AdminacpController {
    @Autowired
    private AdminacpService adminacpService;

    @RequestMapping("/list")
    public String queryAllAcp(HttpSession session){
        PcAdmin admin = (PcAdmin) session.getAttribute("admin");
        return adminacpService.queryAllAdminacpByAdminid(admin.getAdminid()).toString();
    }
}
