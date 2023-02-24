package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.*;
import com.cykj.mapper.*;
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
    private AdminMapper adminMapper;
    @Autowired
    private AdminacpMapper adminacpMapper;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public JSONObject queryOrderByTerm(long adminid, String min, String max, int state, int page, int size) {
        int index = (page-1)*size;
        JSONObject js = new JSONObject();
        js.put("data",orderMapper.queryOrderByAdminId(adminid,min,max,state,index,size));
        js.put("count",orderMapper.queryCountOrderByAdminId(adminid,min,max,state));
        js.put("code",0);
        js.put("msg","");
        return js;
    }

    @Override
    public JSONObject queryAllOrderByTerm(String min, String max, String adminname, String username, int page, int size) {
        int index = (page-1)*size;
        List<Integer> userarr = userMapper.queryIdByUserName(username);
        List<Integer> adminarr = adminMapper.selectIdByAdminName(adminname);
        JSONObject js = new JSONObject();
        js.put("data",orderMapper.selectAllOrder(min,max,adminarr,userarr,index,size));
        js.put("count",orderMapper.selectCountAllOrder(min,max,adminarr,userarr));
        js.put("code",0);
        js.put("msg","");
        return js;
    }


    @Override
    public JSONObject updateResult(long orderid, String orderResult) {
        JSONObject js = new JSONObject();
        int flag = orderMapper.updateResultOrderByOrderId(orderid,orderResult);
        if(flag > 0){
            js.put("flag",true);
            js.put("msg","诊断完成");
        }else{
            js.put("flag",false);
            js.put("msg","诊断失败");
        }
        return js;
    }

    @Override
    public JSONObject updateState(long orderid, int orderstate) {
        JSONObject js = new JSONObject();
        int flag = orderMapper.updateStateOrderByOrderId(orderid,orderstate);
        if(flag > 0){
            js.put("flag",true);
            js.put("msg","确定预约成功");
        }else{
            js.put("flag",false);
            js.put("msg","确定预约失败");
        }
        return js;
    }

    @Override
    public JSONObject updateUserAndAdminAccount(HttpSession session,long orderid, long userid) {
        JSONObject js = new JSONObject();
        PcAdmin admin = (PcAdmin) session.getAttribute("admin");// 得到当前的咨询师
        PcUser user = userMapper.queryUserById(userid);// 得到用户信息
        int flag = orderMapper.updateStateOrderByOrderId(orderid,2);// 修改预约信息
        if(flag > 0){
            PcAccount account = new PcAccount(0,userid,admin.getAdminid(),null
                    ,"预约",0,admin.getAdminprice());// 创建用户账单实体类
            accountMapper.insertUserAccount(account);// 添加到数据库
            user.setBalance(user.getBalance() - admin.getAdminprice());// 修改用户余额
            userMapper.updateUserBalance(userid,user.getBalance());// 修改到数据库
            PcAdminacp adminacp = new PcAdminacp(0,admin.getAdminid(),admin.getAdminname(),userid,null
                    ,null,0,admin.getAdminprice());// 创建管理员账单信息
            adminacpMapper.insertAdminacp(adminacp);// 添加到数据库
            admin.setAdminbalance(admin.getAdminbalance()+admin.getAdminprice());// 修改当前咨询师余额
            adminMapper.updateAdminbalance(admin.getAdminid(),admin.getAdminbalance());// 修改到数据库
            session.setAttribute("admin",admin);// 重新存入sesseion
            js.put("flag",true);
            js.put("msg","确定预约成功");
        }else{
            js.put("flag",false);
            js.put("msg","确定预约失败");
        }
        return js;
    }

    @Override
    public JSONObject countOrderGroupByAdminId(String min, String max) {
        JSONObject js = new JSONObject();
        js.put("data",orderMapper.countOrderGroupByAdminId(min, max));
        js.put("list",adminMapper.queryAdminName(3));
        return js;
    }
}
