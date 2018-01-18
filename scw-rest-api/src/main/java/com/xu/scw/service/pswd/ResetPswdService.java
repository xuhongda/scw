package com.xu.scw.service.pswd;

import com.xu.scw.bean.TMember;

/**
 * @authorxuhongda on 2017/12/11
 * com.xu.scw.service.pswd
 * scw-parent
 */
public interface ResetPswdService {
    /**
     * 查找用户
     * @param email
     * @return
     */
    TMember find(String email);

    /**
     * 重置密码
     * @param userId
     * @param pswd
     * @return
     */
    boolean resetPaswd(Integer userId,String pswd);
}
