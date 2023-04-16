package com.lzw.studentschedule.utils;

public enum DayOfWeek {
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期日");
    private int day;
    private String dayName;

    private DayOfWeek(int day, String dayName) {
        this.day = day;
        this.dayName = dayName;
    }
    public static DayOfWeek of(int day){
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.day == day) {
                return dayOfWeek;
            }
        }
        return null;
    }

    public int getDay() {
        return day;
    }

    public String getDayName() {
        return dayName;
    }
}
