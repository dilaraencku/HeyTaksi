package com.ismek.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by İhsan on 11/20/2017.
 */
public class DateUtil {

    public static java.sql.Date parseDate(Date cdate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String string = simpleDateFormat.format(cdate);
        Date parsed = null;
        java.sql.Date date;

        if (string.isEmpty()) {
            date = null;
        } else {
            try {
                parsed = simpleDateFormat.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            date = new java.sql.Date(parsed.getTime());
        }

        return date;
    }

    public static java.sql.Date convertToSQLDate(java.util.Date date) {
        java.sql.Date sqlDate = null;

        if (date != null) {
            sqlDate = new java.sql.Date(date.getTime());
        }

        return sqlDate;
    }
}
