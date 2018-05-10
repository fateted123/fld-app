package com.xz.fld.mapper;

import com.xz.fld.domain.Invit;

import java.util.List;

public interface InvitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Invit record);

    int insertSelective(Invit record);

    Invit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Invit record);

    int updateByPrimaryKey(Invit record);

    List<Invit> listInvit(String uid);
}