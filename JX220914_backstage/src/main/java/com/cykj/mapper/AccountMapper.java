package com.cykj.mapper;

import com.cykj.bean.PcAccount;

public interface AccountMapper {
    /**
     * 添加用户账单信息
     * @param account 用户账单
     * @return int
     */
    int insertUserAccount(PcAccount account);
}
