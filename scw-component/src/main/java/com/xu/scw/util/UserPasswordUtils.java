package com.xu.scw.util;

import com.xu.util.MD5Utils;

import static com.xu.scw.pojo.Constants.TIMES;

/**
 * @author xuhongda
 */
public class UserPasswordUtils {
    /**
     * 密码加密
     * @param pwd
     * @return
     */
    public static String digest(String pwd){
        String digest = pwd;
        for (int i = 0; i <TIMES ; i++) {
            digest = MD5Utils.digest(digest);
        }
        return digest;
    }
}
