package com.xz.fld.mapper;

import com.xz.fld.domain.Invit;

public interface InvitMapper {
    int insert(Invit record);

    int insertSelective(Invit record);
}