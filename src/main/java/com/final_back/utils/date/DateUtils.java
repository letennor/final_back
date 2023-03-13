package com.final_back.utils.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

    public static List<String> getDaySevenRangeMMDD() {

        SimpleDateFormat df = new SimpleDateFormat("MM-dd");


        List<String> result = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);


        for (int i = 0; i < 7; i++) {
            calendar.set(Calendar.HOUR_OF_DAY, -24);
            result.add(df.format(calendar.getTime()));
        }

        return result;

    }

    public static List<String> getDaySevenRangeYYMMDD() {

        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");


        List<String> result = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);


        for (int i = 0; i < 7; i++) {
            calendar.set(Calendar.HOUR_OF_DAY, -24);
            result.add(df.format(calendar.getTime()));
        }

        return result;

    }

    public static List<Date> getDaySevenRangeDateObj() {

        List<Date> result = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);


        for (int i = 0; i < 7; i++) {
            calendar.set(Calendar.HOUR_OF_DAY, -24);
            result.add(calendar.getTime());
        }

        return result;

    }

    public static Date stringToDate(String s) {
        String str = s + " 00:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            date = format.parse(str);
        } catch (ParseException e) {

        }
        return date;
    }

    public static String dateToString(Date date, String formatType) {
        SimpleDateFormat df = new SimpleDateFormat(formatType);
        return df.format(date);
    }


}
