package com.xz.fld.mapper;

import com.xz.fld.domain.UserDetail;

public interface UserDetailMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}