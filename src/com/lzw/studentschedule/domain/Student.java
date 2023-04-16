package com.lzw.studentschedule.domain;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Student implements User{
    private String username;
    private String password;
    private ArrayList<String> courseselected = new ArrayList<>();
    private PriorityQueue<Course>[] courses =  new PriorityQueue[5];
    public boolean addCourseToQueue(Course course){
        if(courses[course.getCourseDay().getDay()-1] == null){
            courses[course.getCourseDay().getDay()] = new PriorityQueue<>();
        }
        if(courses[course.getCourseDay().getDay()-1].contains(course)){
            return false;
        }
        courses[course.getCourseDay().getDay()-1].offer(course);
        return true;
    }

    public Student(){
        for(int i = 0;i < 5;i++){
            courses[i] = new PriorityQueue<>();
        }
    }
    public Student(String username, String password,String role){
        this.username = username;
        this.password = password;
    }
    public String getRole(){
        return "Student";
    }

    public ArrayList<String> getCourseselected() {
        return courseselected;
    }

    public void setCourseselected(ArrayList<String> courseselected) {
        this.courseselected = courseselected;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public PriorityQueue<Course>[] getCourses() {
        return courses;
    }
    public void setCourses(PriorityQueue<Course>[] courses) {
        this.courses = courses;
    }
}

