package com.cykj.mapper;

import com.cykj.bean.PcAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    /**
     * 管理员登录，通过管理员账号和管理员密码
     * @param adminacc 账号
     * @param adminpwd 密码
     * @return admin
     */
    PcAdmin adminLogin(@Param("acc") String adminacc,@Param("pwd") String adminpwd);

    /**
     * 根据用户账号判断管理员是否存在
     * @param adminacc 管理员账号
     * @return int
     */
    int checkAdminByAcc(@Param("acc") String adminacc);

    /**
     * 根据状态和账号分页模糊查询管理员信息
     * @param name 名称
     * @param state 状态
     * @param index 起始位置
     * @param size 大小
     * @return list
     */
    List<PcAdmin> limitQueryAdminByNameAndAcc(@Param("name")String name,
                                              @Param("state")long state,
                                              @Param("index")int index,
                                              @Param("size")int size);

    /**
     * 根据状态和账号模糊查询管理员总量
     * @param name 名称
     * @param state 状态
     * @return int
     */
    int queryAllAdminByNameAndAcc(@Param("name")String name,
                                  @Param("state")long state);

    /**
     * 添加管理员信息
     * @param admin 管理员
     * @return int
     */
    int addAdmin(PcAdmin admin);

    /**
     * 根据管理员id修改用户状态
     * @param adminid 用户id
     * @return int
     */
    int updateAdminState(@Param("adminid") long adminid);

    /**
     * 根据管理员id重置管理员密码
     * @param adminid 管理员id
     * @return int
     */
    int resetAdminPwdByAdminid(@Param("adminid")long adminid,@Param("adminpwd")String pwd);

    /**
     * 根据管理员id假删除管理员
     * @param adminid 管理员id
     * @return int
     */
    int delAdminByAdminId(@Param("adminid") long adminid);

    /**
     * 根据管理员id查询管理员信息
     * @param adminid 管理员id
     * @return admin
     */
    PcAdmin selectAdminByAdminId(@Param("adminid") long adminid);

    /**
     * 根据管理员名称模糊查询管理员id
     * @param adminname 管理员名称
     * @return list
     */
    List<Integer> selectIdByAdminName(@Param("adminname") String adminname);

    /**
     * 修改管理员账户信息
     * @param adminid 管理员id
     * @param adminbalance  管理员账户
     * @return int
     */
    int updateAdminbalance(@Param("adminid")long adminid,@Param("adminbalance")double adminbalance);

    /**
     * 查询所有咨询师名称
     * @param roleid 角色id
     * @return list
     */
    List<String> queryAdminName(@Param("roleid")long roleid);
}
