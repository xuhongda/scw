package com.xu.scw.dao.project;

import com.xu.scw.bean.project.ScwName;
import com.xu.scw.bean.project.ScwNameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScwNameMapper {
    long countByExample(ScwNameExample example);

    int deleteByExample(ScwNameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScwName record);

    int insertSelective(ScwName record);

    List<ScwName> selectByExample(ScwNameExample example);

    ScwName selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScwName record, @Param("example") ScwNameExample example);

    int updateByExample(@Param("record") ScwName record, @Param("example") ScwNameExample example);

    int updateByPrimaryKeySelective(ScwName record);

    int updateByPrimaryKey(ScwName record);
}