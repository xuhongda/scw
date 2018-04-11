package com.xu.scw.dao;

import com.xu.scw.bean.TRole;
import com.xu.scw.bean.TRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TRoleMapper {
    long countByExample(TRoleExample example);

    int deleteByExample(TRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRole record);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRoleExample example);

    TRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
    /**
     * 自定义查询
     * 所有已分配的roleid
     * @param userId
     * @return
     */

    List<TRole> queryRoled(Integer userId);

    List<TRole> queryAllRoled(Integer userId);

    /**
     * 传入sql
     */
    List<TRole> queryBySql(TRole role);


}