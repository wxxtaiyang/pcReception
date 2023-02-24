package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcUser;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    /**
     * 根据状态和账号分页模糊查询所有的用户
     * @param name 名字
     * @param state 状态
     * @param page 页数
     * @param size 大小
     * @return list
     */
    List<PcUser> dimQueryUserByNameAndAcc(String name,long state,int page,int size);

    /**
     * 根据状态和账号查询用户长度
     * @param name 名字
     * @param state 状态
     * @return int
     */
    int queryUserSizeByNameAndAcc(String name,long state);

    /**
     * 用户状态修改（取反）
     * @param userid 用户id
     * @return json
     */
    JSONObject updateUserStateByUserId(long userid);

    /**
     * 重置用户密码，改为123456
     * @param userid 用户id
     * @return json
     */
    JSONObject resetUserPasswordByUserId(long userid);

    /**
     * 根据用户id假删除用户
     * @param userid 用户id
     * @return json
     */
    JSONObject deleteUserByUserId(long userid);

    /**
     * 获取新增用户数量
     * @param type 1周，2月，3年
     * @return json
     */
    JSONObject countUserByType(long type);
}
