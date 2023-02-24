package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.*;
import com.cykj.mapper.AccountMapper;
import com.cykj.mapper.AdminMapper;
import com.cykj.mapper.OrderMapper;
import com.cykj.mapper.UserMapper;
import com.cykj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public JSONObject queryAllOrderByUserId(long userid, int page, int size) {
        int index = (page-1)*size;
        JSONObject js = new JSONObject();
        js.put("data",orderMapper.querAllOrderByUserId(userid,index,size));
        js.put("count",orderMapper.querAllLengthOrderByUserId(userid));
        js.put("msg","");
        js.put("code",0);
        return js;
    }

    @Override
    public JSONObject insertOrder(HttpSession session,long adminid,long fieldid,
                                  String date,int time,String problem,double price) {
        JSONObject js = new JSONObject();
        // 获取当前用户
        PcUser user = (PcUser) session.getAttribute("user");
        // 创建预约实体类
        PcOrder order = new PcOrder(user.getUserid(),fieldid,adminid,1,date,time,problem);
        // 判断余额是否充足
        if(user.getBalance()-price < 0){
            // 修改预约状态
            order.setOrderstate(0);
            orderMapper.insertOreder(order);
            js.put("flag",false);
            js.put("msg","余额不足，预约失败");
        }else{
            if(orderMapper.queryOrdertimeByDateAndTime(adminid,date,time).getOrderstate() == 2){
                js.put("flag",false);
                js.put("msg","预约失败，已被预约");
            }else {
                orderMapper.insertOreder(order);// 创建预约信息
                orderMapper.updateOrdertimeByDateAndTime(adminid,date,time);// 修改该时间段可信息
//                user.setBalance(user.getBalance() - price);
//                userMapper.updateUserBalanceByUserid(user);// 修改用户账户信息
//                PcAdmin admin = adminMapper.queryAdminById(adminid);
//                admin.setAdminbalance(admin.getAdminprice()+price);
//                adminMapper.updateAdminBalanceByAdminid(admin);// 修改咨询师账户信息
//                PcAccount account = new PcAccount(0, user.getUserid(), adminid, null, "预约", 0, price);
//                accountMapper.insertAccount(account);// 创建用户账户信息
//                PcAdminacp adminacp = new PcAdminacp(0, adminid, user.getUserid(), null, 0, price);
//                accountMapper.insertAdminacp(adminacp);// 创建管理员账户信息
                js.put("flag", true);
                js.put("msg", "预约成功");
            }
        }
        return js;
    }

    @Override
    public List<PcOrder> queryOrdersByAdminId(long adminid) {
        return orderMapper.queryOrdersByAdminId(adminid);
    }

    @Override
    public JSONObject queryAdminAndUser(long userid, long adminid) {
        JSONObject js = new JSONObject();
        js.put("user",userMapper.queryUserByUserId(userid));
        js.put("admin",adminMapper.queryAdminById(adminid));
        return js;
    }

    @Override
    public JSONObject updateOrderByOrderId(PcOrder order) {
        JSONObject js = new JSONObject();
        int flag = orderMapper.updateOrderResultAndState(order);
        if(flag > 0){
            js.put("flag",true);
            js.put("msg","修改成功");
        }else{
            js.put("flag",false);
            js.put("msg","修改失败");
        }
        return js;
    }

    @Override
    public JSONObject updateOrderStateByOrderId(long orderid, long orderstate) {
        JSONObject js = new JSONObject();
        int flag = orderMapper.updateOrderStateByOrderId(orderid,orderstate);
        if(flag > 0){
            js.put("flag",true);
            js.put("msg","修改成功");
        }else{
            js.put("flag",false);
            js.put("msg","修改失败");
        }
        return js;
    }
}
