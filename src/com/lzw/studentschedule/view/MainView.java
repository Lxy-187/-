package com.lzw.studentschedule.view;
import com.lzw.studentschedule.domain.Course;
import com.lzw.studentschedule.domain.User;
import com.lzw.studentschedule.service.CourseService;
import com.lzw.studentschedule.utils.MyUtils;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainView {
    private int choice;
    private Scanner scanner = new Scanner(System.in);
    private CourseService courseService = new CourseService();

    public void mainView(){
        boolean flag = true;

        System.out.println("======欢迎使用学生日程管理系统======");
        courseService.loadUserData();
        while(flag){
            System.out.println("\t\t\t1.登录");
            System.out.println("\t\t\t2.注册");
            System.out.println("\t\t\t3.退出");
            System.out.print("请输入你的选择: ");
            choice = MyUtils.getInputInt(1,3);
            switch(choice){
                case 1:
                    loginView();
                    break;
                case 2:
                    System.out.println("谢谢使用，再见");
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
    void loginView(){
        System.out.println("=============登录界面=============");
        System.out.print("请输入用户名: ");
        String username = scanner.next();
        System.out.print("请输入密码: ");
        String password = scanner.next();
        String role = courseService.login(username,password);
        if(role.equals("admin")){
            adminView();
        }else if(role.equals("user")){
            userView();
        }else{
            System.out.println("用户名或密码错误");
        }
    }
    void adminView(){
        boolean flag = true;
        System.out.println("==========欢迎进入管理员界面==========");
        while(flag){
            System.out.println("1.发布课程");
            System.out.println("2.更改课程信息");
        }
    }
    void userView(){
        boolean flag = true;
        while(flag){
            System.out.println("==========欢迎进入学生界面==========");
            System.out.println("1.查找课程信息");
            System.out.println("2.查看今日课程");
            System.out.println("3.设置活动闹钟");
            System.out.println("4.查看临时事务信息");
            System.out.println("5.日程导航");
            System.out.print("请输入你的选择: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    findCourseView();
                    break;
                case 2:
                    courseService.remindTodayCourse();
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
    void findCourseView(){
        System.out.println("=============查看课程信息=============");
        System.out.print("请输入课程名称:");
        String courseName = scanner.next();
        courseService.findCourse(courseName);
    }
}
