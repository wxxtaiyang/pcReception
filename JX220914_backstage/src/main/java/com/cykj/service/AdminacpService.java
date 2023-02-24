package com.cykj.service;

import com.alibaba.fastjson.JSONObject;

public interface AdminacpService {
    /**
     * 根据管理员id查找该管理员的资金账户详情
     * @param adminid 管理员id
     * @return json
     */
    JSONObject queryAllAdminacpByAdminid(long adminid);
}
