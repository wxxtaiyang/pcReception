package com.cykj.mapper;

import com.cykj.bean.PcPower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PowerMapper {
    /**
     * 根据角色id获取角色权限
     * @param roleid 角色id
     * @return list
     */
    List<PcPower> getPowerListByRole(@Param("roleid")long roleid);

    /**
     * 根据角色id获取该角色未拥有的权限(包扣父级名称)
     * @param roleid 角色id
     * @return list
     */
    List<PcPower> getPowerListByNotRoleId(@Param("roleid")long roleid);

    /**
     * 批量删除角色权限
     * @param roleid 角色id
     * @return int
     */
    int deleteRolePower(@Param("roleid") long roleid);
    /**
     * 批量添加角色权限
     * @param roleid 角色id
     * @param list 权限id
     * @return int
     */
    int addRolePower(@Param("roleid") long roleid,@Param("arr") List<Integer> list);
}
