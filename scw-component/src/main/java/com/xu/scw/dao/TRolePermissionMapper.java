package com.xu.scw.dao;

import com.xu.scw.bean.TRolePermission;
import com.xu.scw.bean.TRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TRolePermissionMapper {
    long countByExample(TRolePermissionExample example);

    int deleteByExample(TRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRolePermission record);

    int insertSelective(TRolePermission record);

    List<TRolePermission> selectByExample(TRolePermissionExample example);

    TRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRolePermission record, @Param("example") TRolePermissionExample example);

    int updateByExample(@Param("record") TRolePermission record, @Param("example") TRolePermissionExample example);

    int updateByPrimaryKeySelective(TRolePermission record);

    int updateByPrimaryKey(TRolePermission record);

    /**
     * 自定义查询
     * @param roleId
     * @param list
     */
    int insertPermission(@Param("roleId") Integer roleId, @Param("list") List<Integer> list);
}