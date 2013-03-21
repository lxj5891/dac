package com.antony.dao;

import com.antony.vo.Cu0001;
import com.antony.vo.Cu0001Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Cu0001Mapper {
    int countByExample(Cu0001Example example);

    int deleteByExample(Cu0001Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cu0001 record);

    int insertSelective(Cu0001 record);

    List<Cu0001> selectByExample(Cu0001Example example);

    Cu0001 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cu0001 record, @Param("example") Cu0001Example example);

    int updateByExample(@Param("record") Cu0001 record, @Param("example") Cu0001Example example);

    int updateByPrimaryKeySelective(Cu0001 record);

    int updateByPrimaryKey(Cu0001 record);

    int getNextId();
}