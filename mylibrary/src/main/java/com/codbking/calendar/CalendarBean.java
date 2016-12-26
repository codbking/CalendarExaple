package com.codbking.calendar;


public class CalendarBean {

    public int year;
    public int moth;
    public int day;
    public int week;

    //-1,0,1
    public int mothFlag;

    //显示
    public String chinaMonth;
    public String chinaDay;

    public CalendarBean(int year, int moth, int day) {
        this.year = year;
        this.moth = moth;
        this.day = day;
    }

    public String getDisplayWeek(){
        String s="";
         switch(week){
             case 1:
                 s="星期日";
          break;
             case 2:
                 s="星期一";
          break;
             case 3:
                 s="星期二";
                 break;
             case 4:
                 s="星期三";
                 break;
             case 5:
                 s="星期四";
                 break;
             case 6:
                 s="星期五";
                 break;
             case 7:
                 s="星期六";
                 break;

         }
        return s ;
    }

    @Override
    public String toString() {
//        String s=year+"/"+moth+"/"+day+"\t"+getDisplayWeek()+"\t农历"+":"+chinaMonth+"/"+chinaDay;
        String s=year+"/"+moth+"/"+day;
        return s;
    }
}