package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAdmin;
import com.cykj.mapper.AdminMapper;
import com.cykj.mapper.FieldMapper;
import com.cykj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private FieldMapper fieldMapper;

    @Override
    public JSONObject adminLogin(HttpSession session, String adminacc, String adminpwd,String code) {
        JSONObject js = new JSONObject();
        String identify = session.getAttribute("identify").toString();
        if(!identify.equalsIgnoreCase(code)){
            js.put("msg","验证码错误");
            js.put("flag",false);
            return js;
        }
        PcAdmin admin = adminMapper.adminLogin(adminacc,adminpwd);
        if(admin == null){
            js.put("msg","账号或密码错误");
            js.put("flag",false);
        }else if(admin.getAdminstate() == 0){
            js.put("msg","该管理员账号被冻结，无法使用");
            js.put("flag",false);
        }else{
            session.setAttribute("admin",admin);
            js.put("msg","登录成功");
            js.put("flag",true);
        }
        return js;
    }

    @Override
    public JSONObject fuzzyQueryAdmin(String name, long state, int page, int limit) {
        JSONObject js = new JSONObject();
        int index = (page-1)*limit;
        js.put("data",adminMapper.limitQueryAdminByNameAndAcc(name, state, index, limit));
        js.put("count",adminMapper.queryAllAdminByNameAndAcc(name, state));
        js.put("code",0);
        js.put("msg","");
        return js;
    }

    @Override
    public JSONObject addAdmin(PcAdmin admin, List<Integer> arr) {
        JSONObject js = new JSONObject();
        if(adminMapper.checkAdminByAcc(admin.getAdminacc()) > 0){
            js.put("msg","该账号已存在");
            js.put("flag",false);
            return js;
        }
        if(adminMapper.addAdmin(admin) > 0){
            if(admin.getRoleid() == 3){
                fieldMapper.addFieldByAdminId(admin.getAdminid(),arr);
            }
            js.put("msg","添加成功");
            js.put("flag",true);
        }else
        {
            js.put("msg","添加失败，服务器错误");
            js.put("flag",false);
        }
        return js;
    }

    @Override
    public JSONObject updateAdmin(long adminid) {
        JSONObject js = new JSONObject();
        js.put("flag",adminMapper.updateAdminState(adminid));
        return js;
    }

    @Override
    public JSONObject resetAdmin(long adminid) {
        JSONObject js = new JSONObject();
        js.put("flag",adminMapper.resetAdminPwdByAdminid(adminid,"123456"));
        return js;
    }

    @Override
    public JSONObject delAdmin(long adminid) {
        JSONObject js = new JSONObject();
        js.put("flag",adminMapper.delAdminByAdminId(adminid));
        return js;
    }

    @Override
    public PcAdmin queryAdminById(long adminid) {
        return adminMapper.selectAdminByAdminId(adminid);
    }
}
