package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.Data;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {
    /**
     * 根据咨询师id分页查询预约信息
     * @param adminid 咨询师id
     * @param min 起始预约日期
     * @param max 终止预约日期
     * @param state 状态
     * @param page 当前页
     * @param size 长度
     * @return list
     */
    JSONObject queryOrderByTerm(long adminid,String min,String max,int state,int page,int size);

    /**
     * 查询所有的预约信息，根据条件
     * @param min 起始预约日期
     * @param max 终止预约日期
     * @param adminname 咨询师名称
     * @param username 用户名称
     * @param page 当前页
     * @param size 长度
     * @return json
     */
    JSONObject queryAllOrderByTerm(String min,String max,String adminname,String username,int page,int size);

    /**
     * 咨询师诊断回复
     * @param orderid 预约id
     * @param orderResult 预约回复
     * @return json
     */
    JSONObject updateResult(long orderid,String orderResult);

    /**
     * 根据orderid修改预约状态
     * @param orderid 预约id
     * @param orderstate 预约状态
     * @return json
     */
    JSONObject updateState(long orderid,int orderstate);

    /**
     * 管理员确定预约
     * @param session session
     * @param orderid 预约id
     * @param userid 用户id
     * @return
     */
    JSONObject updateUserAndAdminAccount(HttpSession session, long orderid, long userid);

    /**
     * 根据日期查询咨询师的预约情况
     * @param min 开始时间
     * @param max 结束时间
     * @return json
     */
    JSONObject countOrderGroupByAdminId(String min, String max);
}
