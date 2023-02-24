package com.cykj.mapper;

import com.cykj.bean.PcField;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FieldMapper {
    /**
     * 查询所有领域信息
     * @return list
     */
    List<PcField> queryAllField();

    /**
     * 添加咨询师领域信息
     * @param adminid 管理员id
     * @param arr 领域集合
     * @return int
     */
    int addFieldByAdminId(@Param("adminid")long adminid,@Param("arr")List<Integer> arr);
}
