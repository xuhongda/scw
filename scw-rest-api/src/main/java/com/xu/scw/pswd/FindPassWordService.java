package com.xu.scw.pswd;

/**
 * @authorxuhongda on 2017/12/11
 * com.xu.scw.pswd
 * scw-parent
 */
public interface FindPassWordService {

    boolean findEmail(String email);

    boolean findMember(String loginacct);
}
