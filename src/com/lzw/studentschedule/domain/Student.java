package com.lzw.studentschedule.domain;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Student {
    private String username;
    private String password;
    private ArrayList<String> courseselected = new ArrayList<>();

    public Student(){
    }
    public Student(String username, String password){
        this.username = username;
        this.password = password;
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
}

