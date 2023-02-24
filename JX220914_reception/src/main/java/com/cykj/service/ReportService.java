package com.cykj.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpSession;

public interface ReportService {
    /**
     * 根据得分获取用户报告
     * @param session session
     * @param num 得分
     * @param fieldid 领域id
     * @return json
     */
    JSONObject insertReport(HttpSession session,long num,long fieldid);

    /**
     * 根据用户id分页查询报告
     * @param userid 用户id
     * @param page 当前页
     * @param size 长度
     * @return json
     */
    JSONObject queryReportByUserId(long userid,int page,int size);
}
