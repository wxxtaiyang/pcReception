package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcUser;

import javax.servlet.http.HttpSession;

public interface UserService {
    /**
     * 通过账号密码验证码判断用户是否登录成功
     * @param acc 账号
     * @param pwd 密码
     * @param code 验证码
     * @return json
     */
    JSONObject userLogin(HttpSession session,String acc, String pwd, String code);

    /**
     * 用户注册
     * @param user 用户类
     * @return json
     */
    JSONObject userRegister(PcUser user);
}
