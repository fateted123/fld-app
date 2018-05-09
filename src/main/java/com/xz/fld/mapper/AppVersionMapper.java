package com.xz.fld.mapper;

import com.xz.fld.domain.AppVersion;

public interface AppVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    AppVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    AppVersion getCurrent(byte platform);
}