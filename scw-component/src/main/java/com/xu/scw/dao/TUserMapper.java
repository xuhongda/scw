package com.xu.scw.dao;

import com.xu.scw.bean.TUser;
import com.xu.scw.bean.TUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TUserMapper {
    /**
     * 查询出总数
     * @param example
     * @return
     */
    long countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    /**
     * 查出id位数
     * @param userId
     * @return
     */
    Integer selectNum(@Param("id") Integer userId);
}