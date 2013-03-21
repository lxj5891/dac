package com.antony.dao;

import com.antony.vo.Sm3001;
import com.antony.vo.Sm3001Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sm3001Mapper {
    int countByExample(Sm3001Example example);

    int deleteByExample(Sm3001Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sm3001 record);

    int insertSelective(Sm3001 record);

    List<Sm3001> selectByExample(Sm3001Example example);

    Sm3001 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sm3001 record, @Param("example") Sm3001Example example);

    int updateByExample(@Param("record") Sm3001 record, @Param("example") Sm3001Example example);

    int updateByPrimaryKeySelective(Sm3001 record);

    int updateByPrimaryKey(Sm3001 record);

    int getNextId();
}