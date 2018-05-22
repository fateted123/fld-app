package com.xz.fld.mapper;

import com.xz.fld.domain.Userfeedback;

public interface UserfeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userfeedback record);

    int insertSelective(Userfeedback record);

    Userfeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userfeedback record);

    int updateByPrimaryKey(Userfeedback record);
}