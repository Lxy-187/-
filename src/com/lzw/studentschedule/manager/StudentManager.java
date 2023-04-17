package com.lzw.studentschedule.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lzw.studentschedule.domain.Course;
import com.lzw.studentschedule.domain.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentManager {
    private HashMap<String, Student> studentMap = new HashMap<>();
    private ArrayList<Student> studentList;
    private static StudentManager studentManager = new StudentManager();
    private String jsonStr;
    public static StudentManager getInstance(){
        return studentManager;
    }
    private static final String STUDENT_DATA_PATH = "resources/userdata.json";
    private StudentManager(){
        try {
            jsonStr = Files.readString(Paths.get(STUDENT_DATA_PATH));
            studentList = JSON.parseObject(jsonStr, new TypeReference<ArrayList<Student>>(){});
        } catch (FileNotFoundException e) {
            System.out.println("学生用户数据文件不存在或者路径错误");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(Student student : studentList){
            studentMap.put(student.getUsername(),student);
        }
    }
    public boolean isStudentName(String username){
        return studentMap.containsKey(username);
    }
    public boolean isStudent(String username, String password){
        return studentMap.get(username).getPassword().equals(password);
    }
    public Student getStudent(String username){
        return studentMap.get(username);
    }
    public  Student of(String username, String password){
       if(studentMap.containsKey(username)){
           return studentMap.get(username);
       }else{
           return new Student(username,password);
       }
    }
    public void addStudent(String username, String password){
        studentList.add(of(username,password));
        studentMap.put(of(username,password).getUsername(),of(username,password));
        jsonStr = JSON.toJSONString(studentList, SerializerFeature.PrettyFormat);
        try {
            Files.writeString(Paths.get(STUDENT_DATA_PATH),jsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCourseToStudent(Student student, String course){
        student.addCourse(course);
        jsonStr = JSON.toJSONString(studentList, SerializerFeature.PrettyFormat);
        try {
            Files.writeString(Paths.get(STUDENT_DATA_PATH),jsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeCourseFromStudent(Student student, String course){
        student.removeCourse(course);
        jsonStr = JSON.toJSONString(studentList, SerializerFeature.PrettyFormat);
        try {
            Files.writeString(Paths.get(STUDENT_DATA_PATH),jsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
