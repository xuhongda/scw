package com.xu.scw.dao;

import com.xu.scw.bean.TAccountTypeCert;
import com.xu.scw.bean.TAccountTypeCertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TAccountTypeCertMapper {
    long countByExample(TAccountTypeCertExample example);

    int deleteByExample(TAccountTypeCertExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAccountTypeCert record);

    int insertSelective(TAccountTypeCert record);

    List<TAccountTypeCert> selectByExample(TAccountTypeCertExample example);

    TAccountTypeCert selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAccountTypeCert record, @Param("example") TAccountTypeCertExample example);

    int updateByExample(@Param("record") TAccountTypeCert record, @Param("example") TAccountTypeCertExample example);

    int updateByPrimaryKeySelective(TAccountTypeCert record);

    int updateByPrimaryKey(TAccountTypeCert record);

    /**
     * 资质维护
     * @param list
     * @return
     */
    int allocateCert(@Param("certList") List<TAccountTypeCert> list);
}