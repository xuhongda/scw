package com.xu.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuhongda on 2017/11/3
 * com.xu.util
 * scw-parent
 */
public class DateUtils {
    public static String currentDateString() {
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String dateString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String dateString(Date date,String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

}
