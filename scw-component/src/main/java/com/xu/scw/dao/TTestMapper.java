package com.xu.scw.dao;

import com.xu.scw.bean.TTest;
import com.xu.scw.bean.TTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTestMapper {
    long countByExample(TTestExample example);

    int deleteByExample(TTestExample example);

    int insert(TTest record);

    int insertSelective(TTest record);

    List<TTest> selectByExample(TTestExample example);

    int updateByExampleSelective(@Param("record") TTest record, @Param("example") TTestExample example);

    int updateByExample(@Param("record") TTest record, @Param("example") TTestExample example);
}