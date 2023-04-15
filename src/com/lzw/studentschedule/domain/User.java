package com.lzw.studentschedule.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class User implements Serializable {
    private String username;
    private String password;
    private String role;
    private ArrayList<String> courseselected = new ArrayList<>();
    private PriorityQueue<Course>[] courses =  new PriorityQueue[5];
    public boolean addCourseToQueue(Course course){
        if(courses[course.getCourseDay()-1] == null){
            courses[course.getCourseDay()] = new PriorityQueue<>();
        }
        if(courses[course.getCourseDay()-1].contains(course)){
            return false;
        }
        courses[course.getCourseDay()-1].offer(course);
        return true;
    }

    public User(){
        for(int i = 0;i < 5;i++){
            courses[i] = new PriorityQueue<>();
        }
    }
    public User(String username, String password,String role){
        this.username = username;
        this.password = password;
        this.role = role;
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
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }

    public PriorityQueue<Course>[] getCourses() {
        return courses;
    }

    public void setCourses(PriorityQueue<Course>[] courses) {
        this.courses = courses;
    }
}
class Student extends User{

}
class Admin extends User{

}
