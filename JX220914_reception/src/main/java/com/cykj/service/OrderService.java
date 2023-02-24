package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcOrder;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {
    /**
     * 根据用户id分页查询预约信息
     * @param userid 用户id
     * @param page 当前页
     * @param size 长度
     * @return json
     */
    JSONObject queryAllOrderByUserId(long userid,int page,int size);

    /**
     * 添加预约信息
     * @param session session
     * @param adminid 咨询师id
     * @param fieldid 领域id
     * @param date 日期
     * @param time 时间段
     * @param problem 问题
     * @return json
     */
    JSONObject insertOrder(HttpSession session, long adminid, long fieldid, String date, int time, String problem,double price);

    /**
     * 根据管理员id查询所有的预约信息
     * @param adminid 管理员id
     * @return list
     */
    List<PcOrder> queryOrdersByAdminId(long adminid);

    /**
     * 根据用户和管理员信息查询用户名称和管理员单价
     * @param userid 用户id
     * @param adminid 管理员id
     * @return  json
     */
    JSONObject queryAdminAndUser(long userid,long adminid);

    /**
     * 通过orderid修改order的回复信息
     * @param order 预约类
     * @return json
     */
    JSONObject updateOrderByOrderId(PcOrder order);

    /**
     * 根据id修改预约状态
     * @param orderid 预约id
     * @param orderstate 预约状态
     * @return json
     */
    JSONObject updateOrderStateByOrderId(long orderid,long orderstate);
}
