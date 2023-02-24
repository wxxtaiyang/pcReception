package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcOrder;
import com.cykj.bean.PcUser;
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

    @RequestMapping("/query")
    public String qureyOrderByUser(HttpSession session, int page, int limit){
        PcUser user = (PcUser) session.getAttribute("user");
        return orderService.queryAllOrderByUserId(user.getUserid(),page,limit).toString();
    }
    @RequestMapping("/insert")
    public String insertOrder(HttpSession session,
                              long adminid,
                              long fieldid,
                              String date,
                              int time,
                              String problem,
                              double price){
        return orderService.insertOrder(session, adminid, fieldid, date, time, problem, price).toString();
    }

    @RequestMapping("/select")
    public String queryOrdersByAdminID(long adminid){
        return JSONObject.toJSONString(orderService.queryOrdersByAdminId(adminid));
    }
    @RequestMapping("/auName")
    public String queryAdminAndUser(long userid,long adminid){
        return orderService.queryAdminAndUser(userid,adminid).toString();
    }

    @RequestMapping("/updateresult")
    public String userResulByOrderId(long orderid,String result){
        PcOrder order = new PcOrder();
        order.setOrderid(orderid);
        order.setOrderrate(result);
        return orderService.updateOrderByOrderId(order).toString();
    }

    @RequestMapping("/updatestate")
    public String updateOrderByOrderId(long orderid,long orderstate){
        orderstate+=5;
        return orderService.updateOrderStateByOrderId(orderid,orderstate).toString();
    }

}
