package com.lzw.studentschedule.service;
import com.lzw.studentschedule.domain.User;
import java.util.HashMap;
import com.lzw.studentschedule.domain.Course;
public class CourseService {
    HashMap<String,User> userMap = new HashMap<>();
    HashMap<String,Course> courseMap = new HashMap<>();
    public void loadUserData(){
        userMap.put("admin",new User("admin","admin","admin"));
        userMap.put("user",new User("user","user","user"));
    }

    public void loadCourseData(){
        //课程名称，课程时间，课程地点，授课教师，上课周次，上课星期，上课节次
        courseMap.put("Java",new Course("Java","2020-2021-1","A-101","张三","1-16","1","1-2"));
        courseMap.put("C++",new Course("C++","2020-2021-1","A-102","李四","1-16","2","3-4"));
        courseMap.put("Python",new Course("Python","2020-2021-1","A-103","王五","1-16","3","5-6"));
        courseMap.put("C#",new Course("C#","2020-2021-1","A-104","赵六","1-16","4","7-8"));
        courseMap.put("JavaScript",new Course("JavaScript","2020-2021-1","A-105","钱七","1-16","5","9-10"));
    }

    public String login(String username, String password){
        if(userMap.containsKey(username) && userMap.get(username).getPassword().equals(password)){
            return userMap.get(username).getRole();
        }else{
            return "";
        }
    }
    public void findCourse(String courseName){
        if(courseMap.containsKey(courseName)){
            courseMap.get(courseName).printCourse();
        }else{
            System.out.println("The course does not exist");
        }
    }

}
