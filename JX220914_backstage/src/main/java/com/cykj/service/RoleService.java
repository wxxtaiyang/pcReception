package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcRole;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有角色，不包含超级管理员
     * @return json
     */
    JSONObject selectAllRoleNotOne();


}
