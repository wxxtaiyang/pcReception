package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAdmin;
import com.cykj.service.OrdertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/ordertime")
public class OrdertimeController {
    @Autowired
    private OrdertimeService ordertimeService;

    @RequestMapping("/query")
    public String queryOrdertime(HttpSession session,String data){
        PcAdmin admin = (PcAdmin) session.getAttribute("admin");
        return JSONObject.toJSONString(ordertimeService.queryOrdertimeByAdminidAndDate(admin.getAdminid(),data));
    }
    @RequestMapping("/update")
    public String updateOrdertime(HttpSession session,String data,@RequestParam("arr[]") List<Integer> list){
        PcAdmin admin = (PcAdmin) session.getAttribute("admin");
        return ordertimeService.updateOrderTimeByAdminidAndDate(admin.getAdminid(),data,list).toString();
    }
}
