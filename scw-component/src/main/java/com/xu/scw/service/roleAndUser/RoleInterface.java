package com.xu.scw.service.roleAndUser;

import com.xu.scw.bean.TRole;

import java.util.List;

/**
 * @authorxuhongda on 2017/11/13
 * com.xu.scw.service
 * scw-parent
 */
public interface RoleInterface {
    /**
     *查询所有role
     * @return
     */
    List<TRole> list();

    /**
     * 新增
     * @param tRole
     * @return
     */
    boolean add(TRole tRole);

    /**
     * 删除
     * @param ids
     * @return
     */
    boolean delete(String ids);

    /**
     * 修改
     * @param tRole
     * @return
     */
    boolean edit(TRole tRole);

    TRole selectOne(Integer id);

    /**
     * 搜索功能
     * @return
     */
    List<TRole> seachList(String condition);
}
