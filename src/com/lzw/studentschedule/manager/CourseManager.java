package com.lzw.studentschedule.manager;

import com.alibaba.fastjson.JSON;
import com.lzw.studentschedule.domain.Course;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class CourseManager {
    private static final String COURSE_DATA_PATH = "resources/coursedata.json";
    private static CourseManager courseManager = new CourseManager();
    public static CourseManager getInstance(){
        return courseManager;
    }
    private HashMap<String, Course> coursePool = new HashMap<>();
    public CourseManager(){
        Course[] courses = new Course[0];
         try {
            String json = Files.readString(Paths.get(COURSE_DATA_PATH));
            courses = JSON.parseObject(json, Course[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Course course : courses) {
            coursePool.put(course.getCourseName(),course);
        }

    }
    public ArrayList<Course> getCourseList(){
        return new ArrayList<>(coursePool.values());
    }
    public Course createCourse(String courseName, int courseDay, ArrayList<Integer> courseTime){
        if(coursePool.containsKey(courseName)){
            return coursePool.get(courseName);
        }
        Course course = Course.of(courseName,courseDay,courseTime);
        coursePool.put(courseName,course);
        return course;
    }
    public boolean isCourse(String courseName){
        return coursePool.containsKey(courseName);
    }
    public Course getCourse(String courseName){
        return coursePool.get(courseName);
    }
    public void addCourse(){
    }
    public void removeCourse(){
    }
}
