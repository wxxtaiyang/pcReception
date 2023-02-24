package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

public interface ReportService {
    /**
     * //根据条件分页获取所有的用户评估报告
     * @param min 起始日期
     * @param max 结束日期
     * @param minscore 最低分
     * @param maxscore 最高分
     * @param page 当前页
     * @param size 长度
     * @return list
     */
    JSONObject queryAllReport(String min,String max,int minscore,
                              int maxscore,int page,int size);
}
