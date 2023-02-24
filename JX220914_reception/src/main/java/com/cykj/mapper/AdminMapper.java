package com.cykj.mapper;

import com.cykj.bean.PcAdmin;
import com.cykj.bean.PcField;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /**
     * 根据管理员id查询管理员信息
     * @param adminid 管理员id
     * @return list
     */
    PcAdmin queryAdminById(@Param("adminid") long adminid);

    /**
     * 根据管理员id查询领域信息
     * @param adminid 管理员id
     * @return list
     */
    List<PcField> queryFieldByAdminid(@Param("adminid") long adminid);

    /**
     * 修改管理员的余额
     * @param admin 管理员类
     * @return int
     */
    int updateAdminBalanceByAdminid(PcAdmin admin);
}
