package com.xu.scw.service.pswd;

import com.xu.scw.bean.TMember;
import com.xu.scw.bean.TMemberExample;
import com.xu.scw.dao.TMemberMapper;
import com.xu.util.MD5Utils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.UUID;

/**
 * @authorxuhongda on 2017/12/11
 * com.xu.scw.service.pswd
 * scw-parent
 */
@Service
public class ResetPswdImpl implements ResetPswdService {

    @Autowired
    TMemberMapper tMemberMapper;
    @Override
    public TMember find(String email) {

        TMemberExample tMemberExample = new TMemberExample();
        TMemberExample.Criteria criteria = tMemberExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        if(tMembers.size()==1){
            return tMembers.get(0);
        }
        return null;
    }

    @Override
    public boolean resetPaswd(Integer userId,String pswd) {

        TMemberExample tMemberExample = new TMemberExample();
        TMemberExample.Criteria criteria = tMemberExample.createCriteria();
        criteria.andIdEqualTo(userId);
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        if(tMembers.size()==1){
            TMember member = tMembers.get(0);
            //MD5加密
            member.setUserpswd(MD5Utils.digest(pswd));
            tMemberMapper.updateByPrimaryKey(member);
            return true;
        }
        return false;
    }


}
