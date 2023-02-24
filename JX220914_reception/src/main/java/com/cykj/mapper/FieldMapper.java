package com.cykj.mapper;

import com.cykj.bean.PcAdmin;
import com.cykj.bean.PcAdminacp;
import com.cykj.bean.PcField;
import com.cykj.bean.PcOrdertime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FieldMapper {
    /**
     * 查询所有的领域信息
     * @return list
     */
    List<PcField> queryAllField();

    /**
     * 根据领域id查询咨询师信息
     * @param fieldid 领域id
     * @return list
     */
    List<PcAdmin> queryAdminByFieldId(@Param("fieldid") long fieldid);

    /**
     * 根据咨询师id和时间查询可预约时间段
     * @param adminid 咨询师id
     * @param time 时间
     * @return list
     */
    List<PcOrdertime> queryAllByAdminidDatetime(@Param("adminid")long adminid, @Param("time")String time);
}
