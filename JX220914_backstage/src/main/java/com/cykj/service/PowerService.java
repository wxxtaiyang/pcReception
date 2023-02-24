package com.cykj.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface PowerService {
    /**
     * 根据角色id获取角色所有的权限
     * @param roleid 角色id
     * @return json
     */
    JSONObject getPowerByRoleId(long roleid);

    /**
     * 查询非该角色拥有的权限
     * @param roleid 角色id
     * @return json
     */
    JSONObject getNotRolePower(long roleid);

    /**
     * 批量修改角色权限
     * @param roleid 角色id
     * @param arr 权限id
     * @return json
     */
    JSONObject updateRolePower(long roleid, List<Integer> arr);
}
