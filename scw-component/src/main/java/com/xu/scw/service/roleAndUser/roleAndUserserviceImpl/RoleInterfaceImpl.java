package com.xu.scw.service.roleAndUser.roleAndUserserviceImpl;

import com.xu.scw.bean.TRole;
import com.xu.scw.bean.TRoleExample;
import com.xu.scw.dao.TRoleMapper;
import com.xu.scw.service.roleAndUser.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @authorxuhongda on 2017/11/13
 * com.xu.scw.service.roleAndUser.roleAndUserserviceImpl
 * scw-parent
 */
@Service
public class RoleInterfaceImpl implements RoleInterface {
    @Autowired
    TRoleMapper tRoleMapper;

    @Override
    public List<TRole> list() {
        List<TRole> tRoles = tRoleMapper.selectByExample(null);
        return tRoles;
    }

    @Override
    public boolean add(TRole tRole) {
        return tRoleMapper.insert(tRole)>0;
    }

    @Override
    public boolean delete(String ids) {
        List<Integer> list = new ArrayList<>();
        String[] strings = ids.split(",");
        System.out.println(strings);
        for (String id:strings){
            Integer integer = null;
            try {
                integer = Integer.parseInt(id);
                list.add(integer);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        TRoleExample tRoleExample = new TRoleExample();
        TRoleExample.Criteria criteria = tRoleExample.createCriteria();
        criteria.andIdIn(list);
        int i=0;
        try {
             i= tRoleMapper.deleteByExample(tRoleExample);
        }catch (Exception e){

        }
        return i>0;
    }

    @Override
    public boolean edit(TRole tRole) {
        System.out.println(tRole.getName()+tRole.getId());
        int i = tRoleMapper.updateByPrimaryKeySelective(tRole);
        System.out.println(i);
        return i>0;
    }

    @Override
    public TRole selectOne(Integer id) {
        TRole tRole = tRoleMapper.selectByPrimaryKey(id);
        return tRole;
    }

    @Override
    public List<TRole> seachList(String condition) {
        String seaWord = "%"+condition+"%";
        TRoleExample tRoleExample = new TRoleExample();
        TRoleExample.Criteria criteria = tRoleExample.createCriteria();
        criteria.andNameLike(seaWord);
        List<TRole> tRoles = tRoleMapper.selectByExample(tRoleExample);
        return tRoles;
    }
}
