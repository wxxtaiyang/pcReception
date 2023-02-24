package com.cykj.mapper;

import com.cykj.bean.PcRole;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询不包含超级管理员的所有角色
     * @return
     */
    List<PcRole> selectAllRoleNotOne();
}
