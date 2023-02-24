package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAccount;
import com.cykj.bean.PcReport;
import com.cykj.bean.PcUser;
import com.cykj.mapper.AccountMapper;
import com.cykj.mapper.ReportMapper;
import com.cykj.mapper.UserMapper;
import com.cykj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public JSONObject insertReport(HttpSession session, long num,long fieldid) {
        JSONObject js = new JSONObject();
        PcUser user = (PcUser) session.getAttribute("user");
        if(user.getBalance()-50 > 0){
            user.setBalance(user.getBalance() - 50);
            userMapper.updateUserBalanceByUserid(user);// 修改用户账户信息
            session.setAttribute("user",user);//重新将用户信息存入session
            PcAccount account = new PcAccount(0, user.getUserid(), 0, null, "在线评估", 2, 50);
            accountMapper.insertAccount(account);// 创建用户账户信息
            PcReport report = new PcReport();
            report.setUserid(user.getUserid());
            report.setScore(num);
            if(num < 34){
                report.setReportresult("心理扭曲");
                report.setReportcontext("可能存在心理扭曲，需要注意控制个人饮食或者生活习惯");
            }else if(num > 33 && num < 67){
                report.setReportresult("心理平和");
                report.setReportcontext("内心安定");
            }else{
                report.setReportresult("开朗外向");
                report.setReportcontext("内心开朗");
            }
            report.setFieldid(fieldid);
            reportMapper.insertReport(report);
            js.put("flag",true);
            js.put("msg","答题成功");
        }else{
            js.put("flag",false);
            js.put("msg","余额不足");
        }
        return js;
    }

    @Override
    public JSONObject queryReportByUserId(long userid, int page, int size) {
        JSONObject js = new JSONObject();
        int index = (page-1)*size;
        js.put("data",reportMapper.queryAllReportByUserId(userid, index, size));
        js.put("count",reportMapper.querySizeReportByUserId(userid));
        return js;
    }
}
