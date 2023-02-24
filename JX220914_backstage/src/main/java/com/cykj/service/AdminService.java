package com.cykj.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAdmin;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AdminService {
    /**
     * 管理员通过账号和密码登录后台
     * @param adminacc 账号
     * @param adminpwd 密码
     * @param code 验证码
     * @return amdin
     */
    JSONObject adminLogin(HttpSession session,String adminacc, String adminpwd,String code);

    /**
     * 根据状态和账号分页模糊查询管理员信息和管理员数量
     * @param name 名称
     * @param state 状态
     * @param page 页数
     * @param limit 大小
     * @return json
     */
    JSONObject fuzzyQueryAdmin(String name,long state,int page,int limit);

    /**
     * 添加管理员信息
     * @param admin 管理员
     * @return json
     */
    JSONObject addAdmin(PcAdmin admin, List<Integer> arr);

    /**
     * 重置管理员状态
     * @param adminid 管理员id
     * @return json
     */
    JSONObject updateAdmin(long adminid);

    /**
     * 重置管理员密码
     * @param adminid 管理员id
     * @return json
     */
    JSONObject resetAdmin(long adminid);

    /**
     * 假删除管理员
     * @param adminid 管理员id
     * @return json
     */
    JSONObject delAdmin(long adminid);

    /**
     * 更具管理员id查询管理员信息
     * @param adminid 管理员id
     * @return
     */
    PcAdmin queryAdminById(long adminid);
}
