package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcField;
import com.cykj.mapper.FieldMapper;
import com.cykj.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldMapper fieldMapper;
    @Override
    public JSONObject queryAllField() {
        JSONObject js = new JSONObject();
        js.put("list",fieldMapper.queryAllField());
        return js;
    }
}
