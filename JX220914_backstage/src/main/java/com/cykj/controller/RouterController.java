package com.cykj.controller;

import com.cykj.utils.GraphValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class RouterController {
    private GraphValidateCode graphValidateCode = new GraphValidateCode();
    // 默认界面
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
//    登录界面
    @RequestMapping("/login")
    public String loign(){
        return "login";
    }
//    验证码
    @RequestMapping("/code")
    public void loign(HttpSession session, HttpServletResponse resp){
        graphValidateCode.responseIdentifyImage(session,resp);
    }
//    主界面
    @RequestMapping("/homepage")
    public String homePage(){
        return "homepage";
    }
//    用户管理界面
    @RequestMapping("/userpage")
    public String userPage(){
        return "userpage";
    }
//    管理员管理界面
    @RequestMapping("/adminpage")
    public String adminPage(){
        return "adminpage";
    }
//    添加管理员界面
    @RequestMapping("/insertadmin")
    public String insertAdmin(){
        return "iframe/insertadmin";
    }
//    资金账户界面
    @RequestMapping("/acpadminpage")
    public String acpAdminPage(){
        return "acpadminpage";
    }
//    预约时间设置
    @RequestMapping("/ordertime")
    public String orderTime(){
        return "ordertime";
    }
//    题库管理
    @RequestMapping("/onlinetopic")
    public String onlineTopic(){
        return "onlinetopic";
    }
//    添加在线题目
    @RequestMapping("/addonline")
    public String addOnline(){
        return "iframe/addonline";
    }
//    修改在线题目
    @RequestMapping("/updateonline")
    public String updateOnline(){
        return "iframe/updateonline";
    }
//    预约诊断
    @RequestMapping("/userorder")
    public String userOrder(){
        return "userorder";
    }
//    预约管理
    @RequestMapping("/adminorder")
    public String adminOrder(){
        return "adminorder";
    }
//    预约详情
    @RequestMapping("/orderdetails")
    public String orderDetails(){
        return "iframe/orderdetails";
    }
//    诊断
    @RequestMapping("/diagnosis")
    public String diagnosis(){
        return "iframe/diagnosis";
    }
//    用户评估报表
    @RequestMapping("/report")
    public String report(){
        return "report";
    }

    @RequestMapping("/reportdetails")
    public String reportDetails(){
        return "iframe/reportdetails";
    }
//    权限管理界面
    @RequestMapping("/powerpage")
    public String powerPage(){
        return "powerpage";
    }
//    用户统计
    @RequestMapping("/countuser")
    public String countUser(){
        return "countuser";
    }
//    渠道数量统计
    @RequestMapping("/countorder")
    public String countOrders(){
        return "countorder";
    }
}
