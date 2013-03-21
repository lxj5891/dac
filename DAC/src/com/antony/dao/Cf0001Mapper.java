package com.antony.dao;

import com.antony.vo.Cf0001;
import com.antony.vo.Cf0001Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Cf0001Mapper {
    int countByExample(Cf0001Example example);

    int deleteByExample(Cf0001Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cf0001 record);

    int insertSelective(Cf0001 record);

    List<Cf0001> selectByExample(Cf0001Example example);

    Cf0001 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cf0001 record, @Param("example") Cf0001Example example);

    int updateByExample(@Param("record") Cf0001 record, @Param("example") Cf0001Example example);

    int updateByPrimaryKeySelective(Cf0001 record);

    int updateByPrimaryKey(Cf0001 record);

    int getNextId();
}