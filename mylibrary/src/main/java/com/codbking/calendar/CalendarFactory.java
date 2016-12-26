package com.codbking.calendar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static android.R.attr.listDivider;
import static android.R.attr.max;
import static android.R.attr.y;
import static android.R.id.list;
import static com.codbking.calendar.CalendarUtil.getDayOfWeek;


/**
 * Created by codbking on 2016/12/16.
 */

public class CalendarFactory {

    private static HashMap<String, List<CalendarBean>> cache = new HashMap<>();

    //获取一月中的集合
    public static List<CalendarBean> getMonthOfDayList(int y, int m) {

        String key=y+""+m;
        if(cache.containsKey(key)){
            List<CalendarBean> list=cache.get(key);
            if(list==null){
                cache.remove(key);
            }else{
                return list;
            }
        }

        List<CalendarBean> list = new ArrayList<CalendarBean>();
        cache.put(key,list);

        //计算出一月第一天是星期几
        int fweek = getDayOfWeek(y, m, 1);
        int total = CalendarUtil.getDayOfMaonth(y, m);

        //根据星期推出前面还有几个显示
        for (int i = fweek - 1; i > 0; i--) {
            CalendarBean bean = geCalendarBean(y, m, 1 - i);
            bean.mothFlag = -1;
            list.add(bean);
        }

        //获取当月的天数
        for (int i = 0; i < total; i++) {
            CalendarBean bean = geCalendarBean(y, m, i + 1);
            list.add(bean);
        }

        //为了塞满42个格子，显示多出当月的天数
        for (int i = 0; i < 42 - (fweek - 1) - total; i++) {
            CalendarBean bean = geCalendarBean(y, m, total + i + 1);
            bean.mothFlag = 1;
            list.add(bean);
        }
        return list;
    }


    public static CalendarBean geCalendarBean(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DATE);

        CalendarBean bean = new CalendarBean(year, month, day);
        bean.week = CalendarUtil.getDayOfWeek(year, month, day);
        String[] chinaDate = ChinaDate.getChinaDate(year, month, day);
        bean.chinaMonth = chinaDate[0];
        bean.chinaDay = chinaDate[1];

        return bean;
    }

    public static void main(String[] args) {
    }


}
