package com.IoT.data.access.backend.common.utils;


import com.IoT.data.access.backend.common.constant.BasicConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Create by NIUNIU
 * create time 2020-1-20 18:37
 */
public class DateUtil {

    /**
     * 获取N天零点的日期
     * N > 0 : N 天之后的日期
     * N < 0 : N 天之前的日期
     */
    public static String getNDate(Integer n, String type) {
        if (DateConstant.ZERO.equalsIgnoreCase(type)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_ZERO);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, n);
            Date date = calendar.getTime();
            return sdf.format(date);
        } else if (DateConstant.END.equalsIgnoreCase(type)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_END);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, n);
            Date date = calendar.getTime();
            return sdf.format(date);
        } else if (DateConstant.CURRENT.equalsIgnoreCase(type)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_CURRENT);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, n);
            Date date = calendar.getTime();
            return sdf.format(date);
        } else if (DateConstant.DAY.equalsIgnoreCase(type)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_DAY);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, n);
            Date date = calendar.getTime();
            return sdf.format(date);
        } else if (DateConstant.MONTH.equalsIgnoreCase(type)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_MONTH);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, n);
            Date date = calendar.getTime();
            return sdf.format(date);
        } else if (DateConstant.YEAR.equalsIgnoreCase(type)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_YEAR);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, n);
            Date date = calendar.getTime();
            return sdf.format(date);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_CURRENT);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, n);
            Date date = calendar.getTime();
            return sdf.format(date);
        }
    }

    /**
     * 获取当前时间
     */
    public static String getCurrent() {
        SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_CURRENT);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, BasicConstant.ZERO);
        Date date = calendar.getTime();
        return sdf.format(date);
    }

    /**
     * 时间戳转date
     */
    public static Date parse(Long timestamp) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_CURRENT);
        Date date = new Date();
        date.setTime(timestamp);
        return date;
    }

    public static Date parse(Long timestamp, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        date.setTime(timestamp);
        return date;
    }

    /**
     * 时间戳转String
     */
    public static String format(Long timestamp) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_CURRENT);
        Date date = new Date();
        date.setTime(timestamp);
        return sdf.format(date);
    }

    public static String format(Long timestamp, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        date.setTime(timestamp);
        return sdf.format(date);
    }

    /**
     * String 转时间戳
     */
    public static Long getTimeStamp(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_CURRENT);
        Date date = sdf.parse(time);
        return date.getTime();
    }

    public static Long getTimeStamp(String time, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(time);
        return date.getTime();
    }


    /**
     * 获取本月xDate
     */
    public static List<String> getCurrentMonthXDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        List<String> xDate = new ArrayList<>();
        for (int i = BasicConstant.ZERO; i < day; i++) {
            xDate.add(getNDate((-i), DateConstant.DAY));
        }
        return xDate;
    }

    /**
     * 获取上月xDate
     */
    public static List<String> getLastMonthXDate() throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat(DateConstant.FORMAT_MONTH);
        List<String> days = new ArrayList<>();
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.setTime(sdf1.parse(getLastMonth()));
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        for (int i = BasicConstant.ONE; i <= day; i++) {
            days.add(String.valueOf(i));
        }
        return days;
    }

    /**
     * 获取上月日期
     */
    public static String getLastMonth() {
        LocalDate today = LocalDate.now();
        today = today.minusMonths(BasicConstant.ONE);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern(DateConstant.FORMAT_MONTH);
        return formatters.format(today);
    }

    /**
     * 获取指定月所有日期
     */
    public static List<String> getSomeMonthXDate(String month) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.FORMAT_DAY);
        List<String> days = new ArrayList<>();
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(new SimpleDateFormat(DateConstant.FORMAT_MONTH).parse(month));
        String nowDate = sdf.format(new Date());
        while (calendar.get(Calendar.MONTH) + BasicConstant.ONE == Integer.parseInt(month.split("-")[BasicConstant.ONE])) {
            // 至本年月日,不在计算
            if (sdf.format(calendar.getTime()).equals(nowDate)) {
                break;
            }
            days.add(sdf.format(calendar.getTime()));
            calendar.add(Calendar.DATE, BasicConstant.ONE);
        }
        return days;
    }

    /**
     * 获取两个日期之间的时间差
     */
    public static Double calculateDuration(String startTime, String endTime, String unit) throws ParseException {
        Double duration = Math.abs(getTimeStamp(endTime) - getTimeStamp(startTime)) + BasicConstant.ZERO_ZERO;
        return calculate(duration, unit);
    }

    public static Double calculateDuration(Date startTime, Date endTime, String unit) throws ParseException {
        Double duration = Math.abs(startTime.getTime() - endTime.getTime()) + BasicConstant.ZERO_ZERO;
        return calculate(duration, unit);
    }

    private static Double calculate(Double duration, String unit) {
        switch (unit) {
            case DateConstant.SECOND:
                duration = duration / BasicConstant.THOUSAND;
                break;
            case DateConstant.MINUTES:
                duration = duration / (BasicConstant.THOUSAND * BasicConstant.SIXTY);
                break;
            case DateConstant.HOUR:
                duration = duration / (BasicConstant.THOUSAND * BasicConstant.SIXTY * BasicConstant.SIXTY);
                break;
            case DateConstant.DAY:
                duration = duration / (BasicConstant.THOUSAND * BasicConstant.SIXTY * BasicConstant.SIXTY * BasicConstant.TWENTY_FOUR);
                break;
        }
        return MathUtil.retain(duration, BasicConstant.TWO);
    }


    public static class DateConstant {

        public static final String ZERO = "zero";
        public static final String END = "end";
        public static final String CURRENT = "current";
        public static final String YEAR = "year";
        public static final String MONTH = "month";
        public static final String DAY = "day";
        public static final String HOUR = "hour";
        public static final String MINUTES = "minutes";
        public static final String SECOND = "second";
        public static final String MILLISECOND = "millisecond";

        public static final String FORMAT_ZERO = "yyyy-MM-dd 00:00:00";
        public static final String FORMAT_END = "yyyy-MM-dd 23:59:59";
        public static final String FORMAT_CURRENT = "yyyy-MM-dd HH:mm:ss";
        public static final String FORMAT_YEAR = "yyyy";
        public static final String FORMAT_MONTH = "yyyy-MM";
        public static final String FORMAT_DAY = "yyyy-MM-dd";


    }


}
