package com.xu.scw.service.roleAndUser;

import com.xu.scw.bean.TRole;
import com.xu.scw.bean.TUser;
import com.xu.scw.bean.TUserRole;

import java.util.List;

/**
 * @author xuhongda on 2017/11/3
 * com.xu.scw.service
 * scw-parent
 */
public interface UserService {
    /**
     *注册
     * @param tUser
     * @return
     */
    boolean register(TUser tUser);

    /**
     * 登陆
     * @param tUser
     * @return
     */
    long login(TUser tUser);

    /**
     *修改
     * @param tUser
     * @return
     */
    boolean update(TUser tUser);

    /**
     * 删除
     * @param ids
     * @return
     */
    boolean delete(String ids);

    /**
     * 查询所有角色
     * @param userId
     * @return
     */
    List<TRole> queryRole(Integer userId);

    /**
     * 查出已分配的角色
     * @param userId
     * @return
     */
    List<TRole> queryRoled(Integer userId);

    List<TRole> queryAllRoled(Integer userId);

    /**
     * 添加角色
     * @param
     * @return
     */
    boolean insertTroleUser(Integer userid,String roleid);

    boolean deleteRole(TUserRole tUserRole);

    Integer selectIdByname(String userName);

    int selectNum(Integer userId);
}
