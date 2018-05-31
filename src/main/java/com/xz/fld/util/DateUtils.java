package com.xz.fld.util;


import com.xz.fld.exception.BizException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String patter_str = "yyyy-MM-dd HH:mm:ss";
    public static final String patter_str_yyyy_mm_dd = "yyyy-MM-dd";
    public static final String patter_str_yyyymmddhhmmss = "yyyyMMddhhmmss";

    public static String dateToString(Date date) {
        if (null == date) {
            return null;
        }

        return new SimpleDateFormat(patter_str).format(date);
    }

    public static String dateToString(Date date, String patter) {
        return new SimpleDateFormat(patter).format(date);
    }

    public static String dateToYYYYMMDD(Date date) {
        return new SimpleDateFormat(patter_str_yyyy_mm_dd).format(date);
    }

    public static Date stringToDate(String date) {
        try {
            return new SimpleDateFormat(patter_str_yyyy_mm_dd).parse(date);
        } catch (ParseException e) {
            throw new BizException("时间处理错误");
        }
    }
}
