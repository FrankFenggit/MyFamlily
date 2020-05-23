package com.frank.bumyfamily.dao;

import com.frank.bumyfamily.entity.AccoutTypePo;
import java.util.List;

public interface AccoutTypePoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccoutTypePo record);

    AccoutTypePo selectByPrimaryKey(Integer id);

    List<AccoutTypePo> selectAll();

    int updateByPrimaryKey(AccoutTypePo record);
}