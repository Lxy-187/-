package com.lzw.studentschedule.domain;

public class Course {
    private String courseID;
    private String courseName;
    private String courseTime;
    private String courseLocation;
    private String courseTeacher;
    private String courseWeek;
    private String courseDay;
    private String courseSection;
    public Course(String courseName, String courseTime, String courseLocation, String courseTeacher, String courseWeek, String courseDay, String courseSection){
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courseLocation = courseLocation;
        this.courseTeacher = courseTeacher;
        this.courseWeek = courseWeek;
        this.courseDay = courseDay;
        this.courseSection = courseSection;
    }
    //输出内容用中文
    public void printCourse(){
        System.out.println("课程名称：" + courseName);
        System.out.println("课程时间：" + courseTime);
        System.out.println("课程地点：" + courseLocation);
        System.out.println("授课教师：" + courseTeacher);
        System.out.println("上课周次：" + courseWeek);
        System.out.println("上课星期：" + courseDay);
        System.out.println("上课节次：" + courseSection);
    }
    public String getCourseID(){
        return courseID;
    }
    public void setCourseID(String courseID){
        this.courseID = courseID;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public String getCourseTime(){
        return courseTime;
    }
    public void setCourseTime(String courseTime){
        this.courseTime = courseTime;
    }
    public String getCourseLocation(){
        return courseLocation;
    }
    public void setCourseLocation(String courseLocation){
        this.courseLocation = courseLocation;
    }
    public String getCourseTeacher(){
        return courseTeacher;
    }
    public void setCourseTeacher(String courseTeacher){
        this.courseTeacher = courseTeacher;
    }
    public String getCourseWeek(){
        return courseWeek;
    }
    public void setCourseWeek(String courseWeek){
        this.courseWeek = courseWeek;
    }
    public String getCourseDay(){
        return courseDay;
    }
    public void setCourseDay(String courseDay){
        this.courseDay = courseDay;
    }
    public String getCourseSection(){
        return courseSection;
    }
    public void setCourseSection(String courseSection){
        this.courseSection = courseSection;
    }
}
