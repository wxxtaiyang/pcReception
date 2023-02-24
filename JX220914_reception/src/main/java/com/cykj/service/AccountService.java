package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAccount;
import com.cykj.bean.PcUser;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AccountService {
    /**
     * 根据用户id查询用户账户信息
     * @param userid 用户id
     * @return list
     */
    JSONObject queryAccountByUserId(long userid);

    /**
     * 更具用户id添加用户账户信息
     * @param session session
     * @param account 账户类
     * @return json
     */
    JSONObject insertAccontByUserId(HttpSession session, PcAccount account);
}
