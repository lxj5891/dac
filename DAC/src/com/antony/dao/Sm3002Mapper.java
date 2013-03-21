package com.antony.dao;

import com.antony.vo.Sm3002;
import com.antony.vo.Sm3002Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sm3002Mapper {
    int countByExample(Sm3002Example example);

    int deleteByExample(Sm3002Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sm3002 record);

    int insertSelective(Sm3002 record);

    List<Sm3002> selectByExample(Sm3002Example example);

    Sm3002 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sm3002 record, @Param("example") Sm3002Example example);

    int updateByExample(@Param("record") Sm3002 record, @Param("example") Sm3002Example example);

    int updateByPrimaryKeySelective(Sm3002 record);

    int updateByPrimaryKey(Sm3002 record);

    int getNextId();
}