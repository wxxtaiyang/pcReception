package com.cykj.mapper;

import com.cykj.bean.PcOrder;
import com.cykj.bean.PcOrdertime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     * 根据用户id分页查询预约的信息
     * @param userid 用户id
     * @param index 位置
     * @param size 长度
     * @return list
     */
    List<PcOrder> querAllOrderByUserId(@Param("userid") long userid,
                                       @Param("index") int index,
                                       @Param("size") int size);

    /**
     * 根据用户id查询预约长度
     * @param userid 用户id
     * @return int
     */
    int querAllLengthOrderByUserId(@Param("userid") long userid);

    /**
     * 添加预约列表
     * @param pcOrder 预约类
     * @return int
     */
    int insertOreder(PcOrder pcOrder);

    /**
     * 根据管理员id，日期，时间段获取预约时间信息
     * @param adminid 管理员id
     * @param date 日期
     * @param time 时间段
     * @return order
     */
    PcOrdertime queryOrdertimeByDateAndTime(@Param("adminid") long adminid,
            @Param("date")String date, @Param("time")int time);

    /**
     * 根据管理员id，日期，时间段修改预约时间信息
     * @param adminid 管理员id
     * @param date 日期
     * @param time 时间段
     * @return int
     */
    int updateOrdertimeByDateAndTime(@Param("adminid") long adminid,
                                     @Param("date")String date, @Param("time")int time);

    /**
     * 根据管理员id查询所有的预约信息
     * @param adminid 管理员id
     * @return list
     */
    List<PcOrder> queryOrdersByAdminId(@Param("adminid")long adminid);

    /**
     * 修改order表的预约回复信息
     * @param order 预约类
     * @return int
     */
    int updateOrderResultAndState(PcOrder order);

    /**
     * 根据orderid修改预约表的状态
     * @param orderid id
     * @param orderstate 当前状态
     * @return int
     */
    int updateOrderStateByOrderId(@Param("orderid") long orderid,@Param("orderstate") long orderstate);
}
