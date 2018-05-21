package com.xz.fld.mapper;

import com.xz.fld.domain.AccountBalance;

public interface AccountBalanceMapper {
    int deleteByPrimaryKey(String userId);

    int insert(AccountBalance record);

    int insertSelective(AccountBalance record);

    AccountBalance selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(AccountBalance record);

    int updateByPrimaryKey(AccountBalance record);
}