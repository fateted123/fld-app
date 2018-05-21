package com.xz.fld.mapper;

import com.xz.fld.domain.WithdrawOrder;

public interface WithdrawOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(WithdrawOrder record);

    int insertSelective(WithdrawOrder record);

    WithdrawOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WithdrawOrder record);

    int updateByPrimaryKey(WithdrawOrder record);
}