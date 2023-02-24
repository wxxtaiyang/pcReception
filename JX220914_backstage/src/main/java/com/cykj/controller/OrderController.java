package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAdmin;
import com.cykj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/userorder")
    public String queryUserOrder(HttpSession session,String min,String max,int state,int page,int limit){
        PcAdmin admin = (PcAdmin) session.getAttribute("admin");
        return orderService.queryOrderByTerm(admin.getAdminid(),min,max,state,page,limit).toString();
    }

    @RequestMapping("/adminorder")
    public String queryAdminOrder(String min,String max,String adminname,String username,int page,int limit){
        return orderService.queryAllOrderByTerm(min, max, adminname, username, page, limit).toString();
    }

    @RequestMapping("/result")
    public String updateResult(long orderid,String result){
        return orderService.updateResult(orderid,result).toString();
    }

    @RequestMapping("/state")
    public String updateState(long orderid,int state){
        return orderService.updateState(orderid,state).toString();
    }

    @RequestMapping("/sureorder")
    public String updateUserAndAdminAccount(HttpSession session,long orderid,long userid){
        return orderService.updateUserAndAdminAccount(session, orderid, userid).toString();
    }

    @RequestMapping("/countorder")
    public String countOrderByAdmin(String min,String max){
        return orderService.countOrderGroupByAdminId(min, max).toString();
    }
}
