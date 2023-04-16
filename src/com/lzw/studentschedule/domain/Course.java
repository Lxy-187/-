package com.lzw.studentschedule.domain;

import com.lzw.studentschedule.utils.DayOfWeek;
import com.lzw.studentschedule.utils.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class Course implements Comparable<Course> {
    private int courseID;
    private String courseName;
    private String courseLocation;
    private DayOfWeek courseDay;
    private ArrayList<TimeSlot> courseTime;
    public static Course of(String courseName, int courseDay,ArrayList<Integer> courseTime){
        return new Course(courseName, courseDay,courseTime);
    }
    public Course(String courseName, int courseDay,ArrayList<Integer> courseTime){
        this.courseName = courseName;
        this.courseDay = DayOfWeek.of(courseDay);
        this.courseTime = TimeSlot.of(courseTime);
    }
    //输出内容用中文
    public void printCourse(){
        System.out.println("课程名称：" + courseName);
        System.out.println("课程地点：" + courseLocation);
        System.out.println("课程时间：" + courseDay.getDayName() + "第" + courseTime + "节");
    }
    @Override
    public int compareTo(Course o) {
        return this.courseTime.get(0).getSlotNum() - o.courseTime.get(0).getSlotNum();
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public String getCourseLocation(){
        return courseLocation;
    }

    public DayOfWeek getCourseDay() {
        return courseDay;
    }

    public int getCourseTime() {
        return courseTime.get(0).getSlotNum();
    }

    public int getCourseID() {
        return courseID;
    }

}

