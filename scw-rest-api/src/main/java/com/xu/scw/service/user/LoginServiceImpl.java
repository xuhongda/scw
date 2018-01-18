package com.xu.scw.service.user;

import com.xu.scw.bean.TMember;
import com.xu.scw.bean.TMemberExample;
import com.xu.scw.dao.TMemberMapper;

import com.xu.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @authorxuhongda on 2017/11/29
 * com.xu.scw.service.user
 * scw-parent
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    TMemberMapper tMemberMapper;
    @Override
    public TMember login(TMember member) {
        TMemberExample tMemberExample = new TMemberExample();
        TMemberExample.Criteria criteria = tMemberExample.createCriteria();
        criteria.andUserpswdEqualTo(MD5Utils.digest(member.getUserpswd())).andLoginacctEqualTo(member.getLoginacct());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        if(tMembers.size()==1){
            return tMembers.get(0);
        }
        return null;
    }

}
