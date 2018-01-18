package com.xu.scw.service.roleAndUser.roleAndUserserviceImpl;

import com.github.pagehelper.util.StringUtil;
import com.xu.scw.bean.*;
import com.xu.scw.dao.TRoleMapper;
import com.xu.scw.dao.TUserMapper;
import com.xu.scw.dao.TUserRoleMapper;
import com.xu.scw.service.roleAndUser.UserService;
import com.xu.scw.util.UserPasswordUtils;
import com.xu.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.xu.scw.pojo.Constants.LOGIN_CASE_ERROR;
import static com.xu.scw.pojo.Constants.LOGIN_CASE_NOUSER;
import static com.xu.scw.pojo.Constants.LOGIN_CASE_SUCCESS;


/**
 * @author xuhongda on 2017/11/3
 * com.xu.scw.service.roleAndUser.roleAndUserserviceImpl
 * scw-parent
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TUserMapper userMapper;
    @Autowired
    TRoleMapper tRoleMapper;
    @Autowired
    TUserRoleMapper tUserRoleMapper;
    /**
     * 处理注册业务
     * @param tUser
     * @return
     */
    @Override
    public boolean register(TUser tUser) {
        //验证账号是否唯一
        long log=checkAccount(tUser);
        if(log != 0 ){
            return false;
        }

        /*后台用户维护页面，设置初始密码*/
        if(StringUtil.isEmpty(tUser.getUserpswd())){
            tUser.setUserpswd("1234");
        }
        tUser.setCreatetime(DateUtils.currentDateString());

        if(tUser.getUsername()==null){
            tUser.setUsername(tUser.getLoginacct());
        }
        tUser.setUserpswd(UserPasswordUtils.digest(tUser.getUserpswd()));
        return userMapper.insertSelective(tUser)>0;
    }

    /**
     * 处理登陆业务
     * @param tUser
     * @return
     */
    @Override
    public long login(TUser tUser) {
        TUserExample tUserExample = new TUserExample();
        TUserExample.Criteria criteria = tUserExample.createCriteria();
        criteria.andLoginacctEqualTo(tUser.getLoginacct());
        //因为密码加密储存了，所以验证时，需要以同样的方式取出验证
        criteria.andUserpswdEqualTo(UserPasswordUtils.digest(tUser.getUserpswd()));
        List<TUser> tUsers = userMapper.selectByExample(tUserExample);
        //验证账号是否存在
        long checkLoginacct = checkAccount(tUser);
        if(checkLoginacct==0){
            return LOGIN_CASE_NOUSER;
        }else if (tUsers.size()==1){
            //验证成功
            return LOGIN_CASE_SUCCESS;
        }else {
            return LOGIN_CASE_ERROR;
        }

    }
    /**
     * 验证账号是否唯一
     * 验证账号是否存在
     * @param tUser
     * @return
     */
    public long checkAccount(TUser tUser){
        TUserExample tUserExample = new TUserExample();
        TUserExample.Criteria criteria = tUserExample.createCriteria();
        criteria.andLoginacctEqualTo(tUser.getLoginacct());
        long l = userMapper.countByExample(tUserExample);
        return l;
    }

    /**
     * 修改用户
     * @param tUser
     * @return
     */
    @Override
    public boolean update(TUser tUser){
        return userMapper.updateByPrimaryKeySelective(tUser)>0;
    }
    /**
     * 删除功能
     * @param ids
     * @return
     */
    @Override
    public boolean delete(String ids) {
        //将字符串以逗号进行分割
        String[] split = ids.split(",");
        Integer integer;
        List<Integer> list = new ArrayList<>();
        int i=0;
        for(String string:split){
            try {
                integer = Integer.valueOf(string);
                list.add(integer);
                //每一次循环查询一次sql语句，性能不好
                //i = userMapper.deleteByPrimaryKey(integer);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        //自定义复杂查询
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        try {
            i = userMapper.deleteByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i>0;
    }

    @Override
    public List<TRole> queryRole(Integer userId) {
        List<TRole> tRoles = tRoleMapper.selectByExample(null);
        return tRoles;
    }

    @Override
    public List<TRole> queryRoled(Integer userId) {
        List<TRole> tRoles = tRoleMapper.queryRoled(userId);
        return tRoles;
    }

    @Override
    public List<TRole> queryAllRoled(Integer userId) {

        return tRoleMapper.queryAllRoled(userId);
    }

    @Override
    public boolean insertTroleUser(Integer userid,String roleid) {
        String[] split = roleid.split(",");
        List list = new ArrayList();
        for(String rid:split){
            int id = Integer.parseInt(rid);
            list.add(id);
        }

        int insert=tUserRoleMapper.insertByList(userid,list);

        return insert>0;
    }

    @Override
    public boolean deleteRole(TUserRole tUserRole) {
        TUserRoleExample tUserRoleExample = new TUserRoleExample();
        TUserRoleExample.Criteria criteria = tUserRoleExample.createCriteria();
        criteria.andRoleidEqualTo(tUserRole.getRoleid());
        int i = tUserRoleMapper.deleteByExample(tUserRoleExample);
        return i>0;
    }

    @Override
    public Integer selectIdByname(String userName) {
        TUserExample tUserExample = new TUserExample();
        TUserExample.Criteria criteria = tUserExample.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<TUser> users = userMapper.selectByExample(tUserExample);
        Integer id=0 ;
        for(TUser user:users){
            id=user.getId();
        }
        if(id!=0){
            return id;
        }else {
            return 0;
        }
    }

    @Override
    public int selectNum(Integer userId) {
        int integer = userMapper.selectNum(userId);
        return integer;
    }

}
