import com.xu.scw.bean.TUser;
import org.junit.Test;

import java.util.Date;

/**
 * @authorxuhongda on 2017/12/10
 * PACKAGE_NAME
 * scw-parent
 */
public class FanXing {
    public static <T>T rest(T a,T b){
        if (a instanceof Date) {
            System.out.println("--This is Date object---");
            System.out.println(a);

        }
        if (a instanceof String) {
            System.out.println("--This is String object---");
            System.out.println(a);
        }

        return a;
    }


    public static <T>T rest(T a,T b,T c){
        T type;
        type=c;
        return type;
    }


    public static void main(String[] args) {
      //  FanXing.rest(new Date(),"0");
        Object a = FanXing.rest("a", 2, new TUser());
        TUser tUser = (TUser) a;
        tUser.setUserpswd("xdxxc");
        System.out.println(tUser.getUserpswd());
    }
}

