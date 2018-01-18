package com.xu.scw.service.user;

import com.xu.scw.bean.TMember;
import com.xu.scw.dao.TMemberMapper;
import com.xu.scw.pojo.EnmuStatus;
import com.xu.scw.pojo.EnmuUserType;
import com.xu.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @authorxuhongda on 2017/12/10
 * com.xu.scw.service.user
 * scw-parent
 */

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    TMemberMapper tMemberMapper;
    @Override
    public boolean register(TMember tMember) {
        //密码加密
        MD5Utils.digest(tMember.getUserpswd());

        //审核状态
       // String code = String.valueOf( EnmuStatus.CHECKING.getCode());
        final String code = EnmuStatus.CHECKING.getCode().toString();
        System.out.println(code);
        tMember.setAuthstatus(code);
        //设置用户名
        tMember.setUsername(tMember.getLoginacct());
        //
        System.out.println(tMember.getUsertype());
        String type =String.valueOf(EnmuUserType.MEMBER.getType());
        tMember.setUsertype(type);
        int i = tMemberMapper.insertSelective(tMember);
        return i>0;
    }

}
