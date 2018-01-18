package com.xu.scw.test;

import com.xu.scw.bean.TUser;
import org.junit.Test;

import java.util.*;

/**
 * @authorxuhongda on 2017/12/10
 * com.xu.scw.test
 * scw-parent
 */
public class HashCodeTest {
    /**
     * 对hashcode。
     */
    @Test
    public void test(){
        TUser tUser = new TUser();
        tUser.setUserpswd("123");
        TUser tUser1 = new TUser();
        tUser1.setUserpswd("123");
        System.out.println(tUser.hashCode());
        System.out.println(tUser1.hashCode());
        Map map = new HashMap();
        map.put("aa",tUser);
        map.put("aa",tUser1);
        System.out.println(map.get("aa"));

    }
    @Test
    public void testIf(){
        if (2==2)
            System.out.println("kk");

    }

    @Test
    public void testStringHash(){
        String str = new String();
        String str2 = new String();
        System.out.println(str==null);
        System.out.println(str.hashCode());
        System.out.println(str2.hashCode());
        Set set = new HashSet();
        set.add(str);
        set.add(str2);
        System.out.println(set.size());
    }
    @Test
    public void testStringHash2(){
        String str = "ss";
        String str2 ="dvd";
        System.out.println(str.hashCode());
        System.out.println(str2.hashCode());
    }
}
