package com.lzw.studentschedule.utils;

import org.junit.Test;

public class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
    public static String timeRangeToString(Time[] timeRange) {
        return String.format("%s-%s", timeRange[0], timeRange[1]);
    }
    public static Time of(int hour, int minute) {
        return new Time(hour, minute);
    }
    public static Time of(int minute){
        return new Time(minute / 60, minute % 60);
    }
    public int toMinute(){
        return hour * 60 + minute;
    }
    // 静态方法，用于解析字符串格式的时间
    public static Time parse(String timeStr) throws IllegalArgumentException {
        try {
            String[] timeParts = timeStr.split(":");
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                throw new IllegalArgumentException("Invalid time string: " + timeStr);
            }
            return new Time(hour, minute);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time string: " + timeStr);
        }
    }

    // 静态方法，用于解析时间段字符串
    public static Time[] parseRange(String rangeStr) throws IllegalArgumentException {
        try {
            String[] rangeParts = rangeStr.split("-");
            Time startTime = Time.parse(rangeParts[0]);
            Time endTime = Time.parse(rangeParts[1]);
            if (startTime.getHour() > endTime.getHour() || (startTime.getHour() == endTime.getHour() && startTime.getMinute() >= endTime.getMinute())) {
                throw new IllegalArgumentException("Invalid range string: " + rangeStr);
            }
            return new Time[] { startTime, endTime };
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid range string: " + rangeStr);
        }
    }
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }

    @Override
    public int compareTo(Time o) {
        return this.toMinute() - o.toMinute();
    }
}

