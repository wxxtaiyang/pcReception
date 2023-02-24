package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcOrdertime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdertimeService {
    /**
     * 根据日期和管理员id查询该日期的时间端
     * @param adminid 管理员id
     * @param data 时间
     * @return list
     */
    List<PcOrdertime> queryOrdertimeByAdminidAndDate(long adminid,String data);

    /**
     * 根据日期和管理员以及时间段修改预约时间
     * @param adminid 管理员id
     * @param data 日期
     * @param list 时间段
     * @return json
     */
    JSONObject updateOrderTimeByAdminidAndDate(long adminid,String data,List<Integer> list);
}
