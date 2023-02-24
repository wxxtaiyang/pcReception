package com.cykj.mapper;

import com.cykj.bean.Data;
import com.cykj.bean.PcAdmin;
import com.cykj.bean.PcOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     * 分页查询所有预约信息
     * @param min 起始预约日期
     * @param max 终止预约日期
     * @param adminarr 咨询师id集合
     * @param userarr 用户id集合
     * @param index 下标
     * @param size 长度
     * @return list
     */
    List<PcOrder> selectAllOrder(@Param("min")String min,
                                 @Param("max")String max,
                                 @Param("adminarr")List<Integer> adminarr,
                                 @Param("userarr")List<Integer> userarr,
                                 @Param("index")int index,
                                 @Param("size")int size);

    /**
     * 查询所有预约信息长度
     * @param min 起始预约日期
     * @param max 终止预约日期
     * @param adminarr 咨询师id集合
     * @param userarr 用户id集合
     * @return int
     */
    int selectCountAllOrder(@Param("min")String min,
                            @Param("max")String max,
                            @Param("adminarr")List<Integer> adminarr,
                            @Param("userarr")List<Integer> userarr);

    /**
     * 根据咨询师id分页查询预约信息
     * @param adminid 咨询师id
     * @param min 起始预约日期
     * @param max 终止预约日期
     * @param state 状态
     * @param index 下标
     * @param size 长度
     * @return list
     */
    List<PcOrder> queryOrderByAdminId(@Param("adminid")long adminid,
                                      @Param("min")String min,
                                      @Param("max")String max,
                                      @Param("state")int state,
                                      @Param("index")int index,
                                      @Param("size")int size);

    /**
     * 根据咨询师id查询预约信息长度
     * @param adminid 咨询师id
     * @param min 起始预约日期
     * @param max 终止预约日期
     * @param state 状态
     * @return int
     */
    int queryCountOrderByAdminId(@Param("adminid")long adminid,
                                 @Param("min")String min,
                                 @Param("max")String max,
                                 @Param("state")int state);

    /**
     * 根据预约id修改预约状态
     * @param orderid 预约id
     * @param orderstate 预约状态
     * @return int
     */
    int updateStateOrderByOrderId(@Param("orderid")long orderid,@Param("orderstate")long orderstate);

    /**
     * 根据预约id修改预约的回复信息
     * @param orderid 预约id
     * @param orderresult 预约回复
     * @return int
     */
    int updateResultOrderByOrderId(@Param("orderid")long orderid,@Param("orderresult")String orderresult);

    /**
     * 根据日期查询咨询师的预约情况
     * @param min 开始时间
     * @param max 结束时间
     * @return list
     */
    List<Data> countOrderGroupByAdminId(@Param("min")String min,@Param("max")String max);
}
