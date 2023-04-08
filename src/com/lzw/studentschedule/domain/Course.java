package com.lzw.studentschedule.domain;

public class Course implements Comparable<Course> {
    private String courseName;
    private int courseTime;
    private int courseDay;
    public static Course of(String courseName, int courseTime, int courseDay){
        return new Course(courseName, courseTime, courseDay);
    }
    public Course(String courseName, int courseTime, int courseDay){
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courseDay = courseDay;
    }
    //输出内容用中文
    public void printCourse(){
        System.out.println("课程名称：" + courseName);
        System.out.println("课程时间：" + courseTime);
        System.out.println("上课星期：" + courseDay);
    }
    @Override
    public int compareTo(Course o) {
        return this.courseTime - o.courseTime;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public int getCourseTime(){
        return courseTime;
    }
    public void setCourseTime(int courseTime){
        this.courseTime = courseTime;
    }

    public int getCourseDay(){
        return courseDay;
    }
    public void setCourseDay(int courseDay){
        this.courseDay = courseDay;
    }

}
