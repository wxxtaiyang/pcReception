package com.cykj.controller;

import com.cykj.utils.GraphValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class RouteController {
    private GraphValidateCode gvCode = new GraphValidateCode();

    @RequestMapping("/identify")
    public void identifyImage(HttpServletResponse resp, HttpSession session){
        gvCode.responseIdentifyImage(session,resp);
    }
//    登录界面
    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }
//    主界面
    @RequestMapping("/homeindex")
    public String homeIndex(){
        return "homeindex";
    }
//    默认显示
    @RequestMapping("/homepage")
    public String homePage(){
        return "homepage";
    }
//    预约界面
    @RequestMapping("/myorder")
    public String myOrder(){
        return "myorder";
    }
//    添加预约
    @RequestMapping("/addorder")
    public String addOrder(){
        return "ifram/addorder";
    }
//    管理员档案
    @RequestMapping("/admindetails")
    public String adminDetails(){
        return "ifram/admindetails";
    }
//    预约详情
    @RequestMapping("/orderdetails")
    public String orderDetails(){
        return "ifram/orderdetails";
    }
//    管理员评价
    @RequestMapping("/adminrate")
    public String adminRate(){
        return "ifram/adminrate";
    }

//    在线答题领域选择
    @RequestMapping("/changfield")
    public String changeField(){
        return "changfield";
    }
//    在线答题题目
    @RequestMapping("/online")
    public String online(){
        return "online";
    }

//    我的报告
    @RequestMapping("/report")
    public String report(){
        return "report";
    }
//    报告详情
    @RequestMapping("/reportdetailed")
    public String reportDetailed(){
        return "ifram/reportdetailed";
    }
//    我的账户
    @RequestMapping("/myaccount")
    public String myAccount(){
        return "myaccount";
    }
}
