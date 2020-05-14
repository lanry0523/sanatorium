package com.yun.sanatorium.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chengde
 * @create 2019/5/20 15:00
 * @desc
 */
@Slf4j
public class DateUtils {

    private static Calendar now;

    private static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

    private static final String yyyyMMddTHHmmssSSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSS Z";

    private static final String yyyyMMdd = "yyyy-MM-dd";

    private static final String HHmmss = "HH:mm:ss";

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdf_time = new SimpleDateFormat(yyyyMMddHHmmss);
        String currentTime = sdf_time.format(Calendar.getInstance().getTime());
        return currentTime;
    }

    /**
     * 将string类型的mongdb日期形式转换为java日期类型
     *
     * @param date
     * @return
     */
    public static Date getDateFromMongDB(String date) {
        date = date.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat(yyyyMMddTHHmmssSSSZ);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期格式转换：yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String parseDate(Date date) {
        return new SimpleDateFormat(yyyyMMdd).format(date);
    }

    /**
     * 日期格式转换：yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat(yyyyMMdd).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得当前年
     *
     * @return
     */
    public static String getCurYear() {
        now = Calendar.getInstance();
        return now.get(Calendar.YEAR) + "";
    }

    /**
     * 获得当前月
     *
     * @return
     */
    public static String getCurMoth() {
        now = Calendar.getInstance();
        return (now.get(Calendar.MONTH) + 1) + "";
    }

    /**
     * 获得当前日期
     *
     * @return
     */
    public static String getCurDay() {
        now = Calendar.getInstance();
        return now.get(Calendar.DAY_OF_MONTH) + "";
    }

    /**
     * 获得当前日期
     *
     * @return
     */
    public static String getCurDate() {
        Date d = new Date();
        return dateToStr(d);
    }

    /**
     * 根据日期字符串获得时分秒字符串"2013-10-31 09:10:00";
     *
     * @param str
     * @return
     */
    public static String getHMS(String str) {
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat(yyyyMMddHHmmss);
            Date d = sdf1.parse(str);
            SimpleDateFormat sdf = new SimpleDateFormat(HHmmss);
            String s = sdf.format(d);
            System.out.println();
            return s;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 将Date对象转换为yyyy-MM-dd HH:mm:ss字符串
     *
     * @param d
     * @return
     */
    public static String dateToStr(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMddHHmmss);
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }
    /**
     * 将Date对象转换为yyyy-MM-dd HH:mm:ss字符串
     *
     * @param d
     * @return
     */
    public static String dateToStr2(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMdd);
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }
    /**
     * 将yyyy-MM-dd HH:mm:ss字符串转换为Date对象
     *
     * @param dstr
     * @return
     */
    public static Date strToDate(String dstr) {
        Date today = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMddHHmmss);
            today = sdf.parse(dstr);
        } catch (Exception e) {
            today = new Date();
        }
        return today;
    }

    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     *
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return long[] 返回值为：{天, 时, 分, 秒}
     * @throws ParseException
     */
    public static long[] getDistanceTimes(String str1, String str2) throws ParseException {
        DateFormat df = new SimpleDateFormat(yyyyMMddHHmmss);
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long[] times = {day, hour, min, sec};
        return times;
    }

    /**
     * 添加天数
     *
     * @param d
     * @param day
     * @return
     */
    public static Date addDate(Date d, long day) {
        long time = d.getTime();
        day = day * 24 * 60 * 60 * 1000;
        time += day;
        return new Date(time);

    }

    /**
     * 获得周几
     *
     * @param s
     * @return
     */
    public static String getWeekName(String s) {
        final String dayNames[] = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
                "星期六"};
        SimpleDateFormat sdfInput = new SimpleDateFormat(yyyyMMdd);
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        try {
            date = sdfInput.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0) {
            dayOfWeek = 0;
        }
        return dayNames[dayOfWeek];
    }

    /**
     * 获取本季度的第一天或最后一天
     *
     * @param date
     * @param isFirst: true 表示开始时间，false表示结束时间
     * @return
     */
    public static String getStartOrEndDayOfQuarter(LocalDate date, Boolean isFirst) {
        LocalDate resDate = LocalDate.now();
        if (date == null) {
            date = resDate;
        }
        Month month = date.getMonth();
        Month firstMonthOfQuarter = month.firstMonthOfQuarter();
        Month endMonthOfQuarter = Month.of(firstMonthOfQuarter.getValue() + 2);
        if (isFirst) {
            resDate = LocalDate.of(date.getYear(), firstMonthOfQuarter, 1);
        } else {
            resDate = LocalDate.of(date.getYear(), endMonthOfQuarter, endMonthOfQuarter.length(date.isLeapYear()));
        }
        return resDate.toString();
    }

    /**
     * 获取精确到秒的时间戳(yyyyMMddHHmmss)
     *
     * @return
     */
    public static String getTimeStamp() {
        String currentTime = getCurrentTime();
        currentTime = currentTime.replace("-", "");
        currentTime = currentTime.replace(" ", "");
        currentTime = currentTime.replace(":", "");
        return currentTime;
    }

    /**
     * 将时间戳转换为时间
     * @param s
     * @return
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
