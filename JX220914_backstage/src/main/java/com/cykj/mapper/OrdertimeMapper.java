package com.cykj.mapper;

import com.cykj.bean.PcOrdertime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdertimeMapper {
    /**
     * 根据日期和管理员id查询该日期的时间端
     * @param adminid 管理员id
     * @param data 时间
     * @return list
     */
    List<PcOrdertime> queryOrdertimeByAdminidAndDate(@Param("adminid")long adminid,@Param("data")String data);

    /**
     * 根据管理员id和日期添加时间段
     * @param adminid 管理员id
     * @param data 日期
     * @param list 时间段
     * @return int
     */
    int insertOrdertimeByAdminidAndDate(@Param("adminid")long adminid,
                                        @Param("data")String data,
                                        @Param("list")List<Integer> list);

    /**
     * 根据管理员id和日删除时间段
     * @param adminid 管理员id
     * @param data 日期
     * @return int
     */
    int deleteOrdertimeByAdminidAndDate(@Param("adminid")long adminid,
                                        @Param("data")String data);
}
