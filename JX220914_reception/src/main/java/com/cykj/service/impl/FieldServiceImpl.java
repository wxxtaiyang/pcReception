package com.cykj.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcField;
import com.cykj.mapper.AdminMapper;
import com.cykj.mapper.FieldMapper;
import com.cykj.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldServiceImpl implements FieldService
{
    @Autowired
    private FieldMapper fieldMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<PcField> queryAllFiled() {
        return fieldMapper.queryAllField();
    }

    @Override
    public JSONObject queryAdminsByFieldId(long fieldid) {
        JSONObject js = new JSONObject();
        js.put("data",fieldMapper.queryAdminByFieldId(fieldid));
        return js;
    }

    @Override
    public JSONObject queryAdminByAdminId(long adminid) {
        JSONObject js = new JSONObject();
        js.put("admin",adminMapper.queryAdminById(adminid));
        js.put("fields",adminMapper.queryFieldByAdminid(adminid));
        return js;
    }

    @Override
    public JSONObject queryAdminacpByAdminidDatetime(long adminid, String time) {
        JSONObject js = new JSONObject();
        js.put("data",fieldMapper.queryAllByAdminidDatetime(adminid,time));
        return js;
    }
}
