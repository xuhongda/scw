package com.xu.scw.dao;

import com.xu.scw.bean.TPermission;
import com.xu.scw.bean.TPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TPermissionMapper {
    long countByExample(TPermissionExample example);

    int deleteByExample(TPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    List<TPermission> selectByExample(TPermissionExample example);

    TPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPermission record, @Param("example") TPermissionExample example);

    int updateByExample(@Param("record") TPermission record, @Param("example") TPermissionExample example);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);

    /**
     * 自定义sql多表联查
     * @param id
     * @return
     */
    List<TPermission> selectRoled(Integer id);

    List<TPermission> selectUserPermission(String  loginacct);;
}