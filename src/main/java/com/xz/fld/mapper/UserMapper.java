package com.xz.fld.mapper;

import com.xz.fld.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByPhone(@Param("phone") String phone);

    int updatePwd(@Param("uid")String uid, @Param("pwd")String pwd);
}