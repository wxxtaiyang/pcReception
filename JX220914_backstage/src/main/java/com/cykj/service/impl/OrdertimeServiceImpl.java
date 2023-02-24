package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcOrdertime;
import com.cykj.mapper.OrdertimeMapper;
import com.cykj.service.OrdertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdertimeServiceImpl implements OrdertimeService {
    @Autowired
    private OrdertimeMapper ordertimeMapper;
    @Override
    public List<PcOrdertime> queryOrdertimeByAdminidAndDate(long adminid, String data) {
        return ordertimeMapper.queryOrdertimeByAdminidAndDate(adminid,data);
    }

    @Override
    public JSONObject updateOrderTimeByAdminidAndDate(long adminid, String data, List<Integer> list) {
        JSONObject js = new JSONObject();
        int i = ordertimeMapper.deleteOrdertimeByAdminidAndDate(adminid, data);
        if(i >= 0){
            ordertimeMapper.insertOrdertimeByAdminidAndDate(adminid, data, list);
            js.put("msg","修改成功");
        }
        return js;
    }
}
