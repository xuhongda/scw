package com.xu.scw.dao;

import com.xu.scw.bean.TRole;
import com.xu.scw.bean.TUserRole;
import com.xu.scw.bean.TUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserRoleMapper {
    long countByExample(TUserRoleExample example);

    int deleteByExample(TUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    List<TUserRole> selectByExample(TUserRoleExample example);

    TUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserRole record, @Param("example") TUserRoleExample example);

    int updateByExample(@Param("record") TUserRole record, @Param("example") TUserRoleExample example);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);


    int insertByList(@Param("id") Integer id,@Param("list") List list);
}