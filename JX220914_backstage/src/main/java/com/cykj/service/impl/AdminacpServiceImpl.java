package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAdminacp;
import com.cykj.mapper.AdminacpMapper;
import com.cykj.service.AdminacpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminacpServiceImpl implements AdminacpService {
    @Autowired
    private AdminacpMapper mapper;
    @Override
    public JSONObject queryAllAdminacpByAdminid(long adminid) {
        JSONObject js = new JSONObject();
        List<PcAdminacp> list = mapper.queryAllAdminacpByAdminid(adminid);
        js.put("data",list);
        js.put("code",0);
        js.put("msg","");
        js.put("count",list.size());
        return js;
    }
}
