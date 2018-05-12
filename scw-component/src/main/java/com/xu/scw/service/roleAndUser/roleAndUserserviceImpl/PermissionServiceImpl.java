package com.xu.scw.service.roleAndUser.roleAndUserserviceImpl;

import com.github.pagehelper.util.StringUtil;
import com.xu.scw.bean.TPermission;
import com.xu.scw.bean.TRolePermissionExample;
import com.xu.scw.dao.TPermissionMapper;
import com.xu.scw.dao.TRolePermissionMapper;
import com.xu.scw.service.roleAndUser.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongda
 */
@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    private TPermissionMapper tPermissionMapper;
    @Autowired
    TRolePermissionMapper tRolePermissionMapper;

    @Override
    public List<TPermission> getAllMenus(String loginacct) {
        //获得所有菜单
        //List<TPermission> menus = tPermissionMapper.selectByExample(null);
        //获取当前用户的权限
        List<TPermission> list = tPermissionMapper.selectUserPermission(loginacct);
        System.out.println("😂😂😂😂😂😂"+list.size());
        //构建好菜单
        List<TPermission> buildMenus = buildMenus(list);
        return buildMenus;
    }

    @Override
    public List<TPermission> getAllPermission() {
        List<TPermission> list = tPermissionMapper.selectByExample(null);
        return list;
    }

    /**
     * 更新角色
     * @return
     */
    @Override
    public boolean updatePermission(Integer roleId, String pid) {
        if(StringUtil.isEmpty(pid)){
            deletePermission( roleId);
        }
        //先删除
        TRolePermissionExample tRolePermissionExample = new TRolePermissionExample();
        TRolePermissionExample.Criteria criteria = tRolePermissionExample.createCriteria();
        criteria.andRoleidEqualTo(roleId);
        int i1 = tRolePermissionMapper.deleteByExample(tRolePermissionExample);
        //后添加
        String[] splits = pid.split(",");
        List<Integer> list = new ArrayList<>();
        for(String s:splits){
            Integer id = Integer.parseInt(s);
            list.add(id);
        }
        int i2 = tRolePermissionMapper.insertPermission(roleId, list);
        return i1+i2>1;
    }


    /**
     * 选中已经分配的权限
     * @param id
     * @return
     */
    @Override
    public List<TPermission> selectRoled(Integer id) {
        List<TPermission> list = tPermissionMapper.selectRoled(id);
        return list;
    }

    /**
     *
     * @param roleId
     *
     * @return
     */
    @Override
    public boolean deletePermission(Integer roleId) {
        TRolePermissionExample tRolePermissionExample = new TRolePermissionExample();
        TRolePermissionExample.Criteria criteria = tRolePermissionExample.createCriteria();
        criteria.andRoleidEqualTo(roleId);
        tRolePermissionMapper.deleteByExample(tRolePermissionExample);
        List list= selectRoled( roleId);
        if(list.size()==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updatName(TPermission permission) {
        int i = tPermissionMapper.updateByPrimaryKeySelective(permission);
        return i>0;
    }

    @Override
    public boolean addNewName(TPermission permission) {

        int i = tPermissionMapper.insertSelective(permission);
        return i>0;
    }

    @Override
    public boolean deleteName(TPermission permission) {
        int i = tPermissionMapper.deleteByPrimaryKey(permission.getId());
        return i>0;
    }

    /**
     * 构建父子菜单关系
     * @param menus
     * @return
     */
    private List<TPermission> buildMenus(List<TPermission> menus){
        //保存所有父标签
        List<TPermission> list = new ArrayList<>();

        Map<Integer,TPermission> map = new HashMap<>(20);
        for(TPermission tPermission:menus){
            //选出父标签
            if(tPermission.getPid()==0){
                list.add(tPermission);
                map.put(tPermission.getId(),tPermission);
            }
        }
        //把对应的子菜单添加
        for(TPermission tPermission:menus){
            Integer pid=tPermission.getPid();
            //选出子标签
            if(pid !=0){
                //找出父标签
                TPermission parentMenus = map.get(pid);
                parentMenus.getChilds().add(tPermission);
            }
        }
        return list;
    }
}
