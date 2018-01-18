package com.xu.scw.service.roleAndUser;

import com.xu.scw.bean.TPermission;

import java.util.List;

/**
 * @author xuhongda
 */
public interface PermissionService {
    /**
     * 获得用户所有主菜单
     * @return
     */
    List<TPermission> getAllMenus(String loginacct);

    /**
     * 获得所有菜单，不分级排序
     * @return
     */
    List<TPermission> getAllPermission();

    /**
     * 更新角色
     * @param roleId
     * @param pid
     * @return
     */
    boolean updatePermission(Integer roleId, String pid);

    /**
     * 选中已经分配的权限
     * @return
     */
    List<TPermission> selectRoled(Integer id);

    boolean deletePermission(Integer roleId);

    /**
     * 更改许可维护名
     * @param permission
     * @return
     */
    boolean updatName(TPermission permission);

    /**
     * 添加Permission
     * @param permission
     * @return
     */
    boolean addNewName(TPermission permission);

    /**
     * 删除Permission
     * @param permission
     * @return
     */
    boolean deleteName(TPermission permission);
}
