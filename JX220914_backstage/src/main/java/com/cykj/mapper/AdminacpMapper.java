package com.cykj.mapper;

import com.cykj.bean.PcAdminacp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminacpMapper {
    /**
     * 根据用户名查找用户的所在资金账户详情
     * @param adminid 用户id
     * @return list
     */
    List<PcAdminacp> queryAllAdminacpByAdminid(@Param("adminid") long adminid);

    /**
     * 添加管理员账户信息
     * @param adminacp 管理员账户
     * @return int
     */
    int insertAdminacp(PcAdminacp adminacp);
}
