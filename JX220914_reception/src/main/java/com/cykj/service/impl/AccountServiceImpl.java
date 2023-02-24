package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAccount;
import com.cykj.bean.PcUser;
import com.cykj.mapper.AccountMapper;
import com.cykj.mapper.UserMapper;
import com.cykj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject queryAccountByUserId(long userid) {
        JSONObject js = new JSONObject();
        List<PcAccount> accounts = accountMapper.queryAccountByUserId(userid);
        js.put("data",accounts);
        js.put("count",accounts.size());
        js.put("code",0);
        js.put("msg","");
        return js;
    }

    @Override
    public JSONObject insertAccontByUserId(HttpSession session,PcAccount account) {
        JSONObject js = new JSONObject();
        int i = accountMapper.insertAccount(account);
        if(i > 0){
            PcUser user = (PcUser) session.getAttribute("user");
            user.setBalance(user.getBalance()+account.getAccountprice());
            userMapper.updateUserBalanceByUserid(user);
            session.setAttribute("user",user);
            js.put("flag",true);
            js.put("msg","充值成功");
        }else{
            js.put("flag",false);
            js.put("msg","充值失败");
        }
        return js;
    }
}
