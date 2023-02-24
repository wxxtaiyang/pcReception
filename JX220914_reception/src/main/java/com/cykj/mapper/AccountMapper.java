package com.cykj.mapper;

import com.cykj.bean.PcAccount;
import com.cykj.bean.PcAdminacp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    /**
     * 添加用户给账单信息
     * @param account 账单类
     * @return int
     */
    int insertAccount(PcAccount account);

    /**
     * 添加管理员账户信息
     * @param adminacp 管理员账户类
     * @return int
     */
    int insertAdminacp(PcAdminacp adminacp);

    /**
     * 根据用户id查询用户账户信息
     * @param userid 用户id
     * @return list
     */
    List<PcAccount> queryAccountByUserId(@Param("userid") long userid);
}
