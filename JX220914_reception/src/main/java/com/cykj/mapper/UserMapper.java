package com.cykj.mapper;

import com.cykj.bean.PcUser;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 通过账号和密码查询用户信息
     * @param acc 账号
     * @param pwd 密码
     * @return PcUser
     */
    PcUser userLogin(@Param("acc") String acc,@Param("pwd") String pwd);

    /**
     * 用户注册账号
     * @param user 用户类
     * @return int
     */
    int userRgister(PcUser user);

    /**
     * 根据用户账号查找用户
     * @param acc 用户账号
     * @return user
     */
    PcUser selectUserByUserAcc(@Param("acc") String acc);

    /**
     * 根据电话号码查询用户信息
     * @param phone 电话号码
     * @return user
     */
    PcUser selectUserByUserPhone(@Param("phone") String phone);

    /**
     * 根据用户id修改用户余额信息
     * @param pcUser 用户类
     * @return int
     */
    int updateUserBalanceByUserid(PcUser pcUser);

    /**
     *  根据用户id查询用户名称
     * @param userid 用户id
     * @return user
     */
    PcUser queryUserByUserId(@Param("userid") long userid);
}
