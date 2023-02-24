package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcUser;
import com.cykj.mapper.UserMapper;
import com.cykj.service.UserService;
import com.cykj.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject userLogin(HttpSession session,String acc, String pwd, String code) {
        StringBuffer identify = (StringBuffer) session.getAttribute("identify");
        String identifyStr = identify.toString();
        JSONObject js = new JSONObject();
        if(!identifyStr.equalsIgnoreCase(code)){
            js.put("msg","验证码错误");
            js.put("flag",false);
            return js;
        }
        pwd = MD5Utils.md5Hex(pwd);
        PcUser user = userMapper.userLogin(acc,pwd);
        if(user == null){
            js.put("msg","账号或密码错误");
            js.put("flag",false);
        }else if(user.getState() == 0){
            js.put("msg","该账号被冻结，无法使用");
            js.put("flag",false);
        } else{
            js.put("msg","登录成功");
            js.put("flag",true);
            session.setAttribute("user",user);
        }
        return js;
    }

    @Override
    public JSONObject userRegister(PcUser user) {
        PcUser pcUser = userMapper.selectUserByUserAcc(user.getUseracc());
        JSONObject js = new JSONObject();
        if(pcUser != null){
            js.put("msg","用户账号重复了，请重新给个");
            js.put("flag",false);
            return js;
        }
        pcUser = userMapper.selectUserByUserPhone(user.getUserphone());
        if(pcUser != null){
            js.put("msg","该联系方式已被注册，请重新输入联系方式");
            js.put("flag",false);
            return js;
        }
        user.setUserpwd(MD5Utils.md5Hex(user.getUserpwd()));
        int flag = userMapper.userRgister(user);
        if(flag > 0 ){
            js.put("msg","注册成功");
            js.put("flag",true);
        }else{
            js.put("msg","注册失败");
            js.put("flag",false);
        }
        return js;
    }
}
