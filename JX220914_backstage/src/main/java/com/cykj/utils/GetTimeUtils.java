package com.cykj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GetTimeUtils {
    public static void main(String[] args) throws ParseException {

        List<String> list = halfYear();
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> getWeekDay() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        }
        Date[] dates = new Date[7];  // new Date[7] 星期日
        for (int i = 0; i < 7; i++) {  // i < 7 星期日
            dates[i] = calendar.getTime();
            calendar.add(Calendar.DATE, 1);
        }
        List<String> strDate = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Date date : dates) {
            strDate.add(dateFormat.format(date));
        }
        return strDate;
    }

    public static List<String> halfYear() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;// 获取当前月
        int year = calendar.get(Calendar.YEAR);// 获取当前年
        List<String> yearMonths = new ArrayList<>();// 声明一个字符串列表
        for (int i = 5; i >=0; i--){
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) + 1;
            if((month-i)<=0){
                year--;
                month = month-i+12;
            }
            else if((month-i)==1){
//                System.out.println("当前年-月"+year+"-"+(month-1));
                month--;
            }
            String zero = "";
            if(month<10){
                zero="0";
            }
            yearMonths.add(year+"-"+zero+month);
        }
        return yearMonths;
    }
}
