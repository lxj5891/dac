package com.antony.service.main.db;

import com.antony.service.main.vo.Cm0001;
import com.antony.service.main.vo.Cm0001Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Cm0001Mapper {
    int countByExample(Cm0001Example example);

    int deleteByExample(Cm0001Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cm0001 record);

    int insertSelective(Cm0001 record);

    List<Cm0001> selectByExample(Cm0001Example example);

    Cm0001 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cm0001 record, @Param("example") Cm0001Example example);

    int updateByExample(@Param("record") Cm0001 record, @Param("example") Cm0001Example example);

    int updateByPrimaryKeySelective(Cm0001 record);

    int updateByPrimaryKey(Cm0001 record);
}