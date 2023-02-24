package com.cykj.mapper;

import com.cykj.bean.Data;
import com.cykj.bean.PcUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
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
     * 根据名字和账号分页模糊查询所有的用户
     * @param name 名字
     * @param state 状态
     * @param index 起始位置
     * @param size 大小
     * @return list
     */
    List<PcUser> queryUserByNameAndAcc(@Param("name") String name,
                                       @Param("state") long state,
                                       @Param("index") int index,
                                       @Param("size") int size);
    /**
     * 根据名字和账号用户大小
     * @param name 名字
     * @param state 状态
     * @return list
     */
    int userSizeByNameAndAcc(@Param("name") String name, @Param("state")long state);

    /**
     * 根据用户id修改用户状态（取反）
     * @param userid 用户id
     * @return int
     */
    int updateUserStateByUserId(@Param("userid")long userid);

    /**
     * 根据用户id重置用户密码
     * @param pwd 密码
     * @return int
     */
    int resetUserPwdByUserId(@Param("pwd")String pwd,@Param("userid")long userid);

    /**
     * 根据用户id假删除用户
     * @param userid 用户id
     * @return int
     */
    int deleteUserByUserId(@Param("userid")long userid);

    /**
     * 根据用户名称模糊查询用户信息
     * @param username 用户名
     * @return list
     */
    List<Integer> queryIdByUserName(@Param("username") String username);

    /**
     * 根据用户id查询用户信息
     * @param userid 用户id
     * @return user
     */
    PcUser queryUserById(@Param("userid")long userid);

    /**
     * 根据用户id修改用户余额
     * @param userid 用户id
     * @param balance 余额
     * @return int
     */
    int updateUserBalance(@Param("userid")long userid,@Param("balance") double balance);

    /**
     * 查询周数据
     * @return list
     */
    List<Data> countUserByWeekTime();

    /**
     * 查询月数据
     * @return list
     */
    List<Data> countUserByMothsTime();

    /**
     * 查询近半年数据
     * @param years 近半年数组
     * @return list
     */
    List<Data> countUserByYearsTime(@Param("years")List<String> years);
}
