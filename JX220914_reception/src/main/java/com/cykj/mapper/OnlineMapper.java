package com.cykj.mapper;

import com.cykj.bean.PcOnlinetopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineMapper {
    /**
     * 根据领域id查询所有题目信息
     * @param fieldid 领域id
     * @return list
     */
    List<PcOnlinetopic> queryOnlineByField(@Param("fieldid")long fieldid);
}
