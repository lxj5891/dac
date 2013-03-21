package com.antony.service.mail.db;

import com.antony.service.mail.vo.Cm3001;
import com.antony.service.mail.vo.Cm3001Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Cm3001Mapper {
    int countByExample(Cm3001Example example);

    int deleteByExample(Cm3001Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cm3001 record);

    int insertSelective(Cm3001 record);

    List<Cm3001> selectByExampleWithBLOBs(Cm3001Example example);

    List<Cm3001> selectByExample(Cm3001Example example);

    Cm3001 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cm3001 record, @Param("example") Cm3001Example example);

    int updateByExampleWithBLOBs(@Param("record") Cm3001 record, @Param("example") Cm3001Example example);

    int updateByExample(@Param("record") Cm3001 record, @Param("example") Cm3001Example example);

    int updateByPrimaryKeySelective(Cm3001 record);

    int updateByPrimaryKeyWithBLOBs(Cm3001 record);

    int updateByPrimaryKey(Cm3001 record);
    
    int MailNextId();
}