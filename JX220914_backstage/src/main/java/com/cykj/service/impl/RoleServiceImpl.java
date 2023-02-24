package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.mapper.RoleMapper;
import com.cykj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public JSONObject selectAllRoleNotOne() {
        JSONObject js = new JSONObject();
        js.put("list",roleMapper.selectAllRoleNotOne());
        return js;
    }

}
