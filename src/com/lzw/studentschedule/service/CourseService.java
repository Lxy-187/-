//package com.lzw.studentschedule.service;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.JSONReader;
//import com.lzw.studentschedule.domain.Student;
//import java.io.*;
//import java.lang.reflect.Type;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.PriorityQueue;
//
//import com.lzw.studentschedule.domain.Course;
//import com.alibaba.fastjson.JSON;
//public class CourseService {
//    HashMap<String,Student> userMap = new HashMap<>();
//    HashMap<String,Course> courseMap = new HashMap<>();
//    User user;
//    final String USER_DATA_PATH = "resources/userdata.json";
//    final String COURSE_DATA_PATH = "resources/coursedata.json";
//    public CourseService(){
//        loadUserData();
//        loadAllCourseData();
//    }
//
//    public String login(String username, String password){
//        if(userMap.containsKey(username) && userMap.get(username).getPassword().equals(password)){
//            user = userMap.get(username);
//            loadAllCourseData();
//            loadUserCourseData();
//            return userMap.get(username).getRole();
//        }else{
//            return "";
//        }
//    }
//
//    public void findCourse(String courseName){
//        if(courseMap.containsKey(courseName)){
//            courseMap.get(courseName).printCourse();
//        }else{
//            System.out.println("The course does not exist");
//        }
//    }
//    public void loadUserData() {
//       User[] users = newUser[0];
//        //将同目录下的userdata.json文件读取到userMap中
//        try {
//            String json = Files.readString(Paths.get(USER_DATA_PATH));
//            users = JSON.parseObject(json,User[].class);
//
//        } catch (FileNotFoundException e) {
//            System.out.println("学生用户数据文件不存在或者路径错误");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        for (User user : users) {
//            userMap.put(user.getUsername(), user);
//        }
//    }
//
//    public void loadAllCourseData(){
//        Course[] courses = new Course[0];
//        try {
//            String json = Files.readString(Paths.get(COURSE_DATA_PATH));
//            courses = JSON.parseObject(json, Course[].class);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        for (Course course : courses) {
//            courseMap.put(course.getCourseName(), course);
//        }
//    }
//    public boolean loadUserCourseData(){
//        if(user == null)
//            return false;
//        else{
//            for(String courseName : user.getCourseselected()){
//                if(courseMap.containsKey(courseName)){
//                    user.addCourseToQueue(courseMap.get(courseName));
//                }
//            }
//            return true;
//        }
//
//    }
//    public void remindSecondDayCourse(){
//
//    }
//    public void remindTodayCourse(){
//        Course course;
//        PriorityQueue<Course> temp = new PriorityQueue<>(user.getCourses()[0]);
//        while(!temp.isEmpty()){
//            course = temp.poll();
//            System.out.println(course.getCourseTime() + ":" + course.getCourseName());
//        }
//    }
//}
