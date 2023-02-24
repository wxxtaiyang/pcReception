package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcUser;
import com.cykj.mapper.UserMapper;
import com.cykj.service.UserService;
import com.cykj.utils.GetTimeUtils;
import com.cykj.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<PcUser> dimQueryUserByNameAndAcc(String name, long state, int page, int size) {
        int index = (page-1)*size;
        return userMapper.queryUserByNameAndAcc(name,state,index,size);
    }

    @Override
    public int queryUserSizeByNameAndAcc(String name, long state) {
        return userMapper.userSizeByNameAndAcc(name,state);
    }

    @Override
    public JSONObject updateUserStateByUserId(long userid) {
        JSONObject js = new JSONObject();
        int i = userMapper.updateUserStateByUserId(userid);
        if (i>0){
            js.put("msg","修改成功");
        }else{
            js.put("msg","修改失败");
        }
        return js;
    }

    @Override
    public JSONObject resetUserPasswordByUserId(long userid) {
        String password = MD5Utils.md5Hex("123456");
        JSONObject js = new JSONObject();
        if(userMapper.resetUserPwdByUserId(password,userid) > 0){
            js.put("msg","修改成功");
        }else{
            js.put("msg","修改失败");
        }
        return js;
    }

    @Override
    public JSONObject deleteUserByUserId(long userid) {
        JSONObject js = new JSONObject();
        if(userMapper.deleteUserByUserId(userid) > 0){
            js.put("msg","删除成功");
            js.put("flag",true);
        }else{
            js.put("msg","删除失败");
            js.put("flag",false);
        }
        return js;
    }

    @Override
    public JSONObject countUserByType(long type) {
        JSONObject js = new JSONObject();
        if(type == 1){
            js.put("list",userMapper.countUserByWeekTime());
        }else if(type == 2){
            js.put("list",userMapper.countUserByMothsTime());
        }else if(type == 3){
            List<String> years = GetTimeUtils.halfYear();
            js.put("list",userMapper.countUserByYearsTime(years));
            js.put("data",years);
        }
        return js;
    }
}
