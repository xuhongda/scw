package com.xu.scw.dao.project;

import com.xu.scw.bean.project.TProjectResource;
import com.xu.scw.bean.project.TProjectResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProjectResourceMapper {
    long countByExample(TProjectResourceExample example);

    int deleteByExample(TProjectResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProjectResource record);

    int insertSelective(TProjectResource record);

    List<TProjectResource> selectByExample(TProjectResourceExample example);

    TProjectResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProjectResource record, @Param("example") TProjectResourceExample example);

    int updateByExample(@Param("record") TProjectResource record, @Param("example") TProjectResourceExample example);

    int updateByPrimaryKeySelective(TProjectResource record);

    int updateByPrimaryKey(TProjectResource record);
}