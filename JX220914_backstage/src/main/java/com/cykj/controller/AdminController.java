package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAdmin;
import com.cykj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String adminLogin(HttpSession session,String adminacc, String adminpwd,String code){
        return adminService.adminLogin(session,adminacc,adminpwd,code).toString();
    }
    @RequestMapping("/exit")
    public void adminOut(HttpSession session,HttpServletRequest req, HttpServletResponse resp){
        session.removeAttribute("admin");
        try {
            resp.sendRedirect(req.getContextPath()+"/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/list")
    public String adminList(String name,long state,int page,int limit){
        return adminService.fuzzyQueryAdmin(name,state,page,limit).toString();
    }

    @RequestMapping("/add")
    public String addAdmin(PcAdmin admin,String arr){
        List<Integer> list = JSONObject.parseArray(arr).toJavaList(Integer.class);
        return adminService.addAdmin(admin,list).toString();
    }

    @RequestMapping("/update")
    public String updateAdmin(long adminid){
        return adminService.updateAdmin(adminid).toString();
    }

    @RequestMapping("/reset")
    public String resetAdmin(long adminid){
        return adminService.resetAdmin(adminid).toString();
    }

    @RequestMapping("/del")
    public String delAdmin(long adminid){
        return adminService.delAdmin(adminid).toString();
    }

    @RequestMapping("/queryid")
    public String queryAdminByID(long adminid){
        return JSONObject.toJSONString(adminService.queryAdminById(adminid));
    }
}
