package com.lzw.studentschedule.view;


import com.lzw.studentschedule.domain.Course;
import com.lzw.studentschedule.domain.Student;
import com.lzw.studentschedule.manager.CourseManager;
import com.lzw.studentschedule.manager.StudentManager;
import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class GUIView extends JFrame {
    private CardLayout cardLayout;
    private CourseManager courseManager = CourseManager.getInstance();
    private StudentManager studentService = StudentManager.getInstance();
    private Student student;
    public GUIView(){
        //设置窗口属性
        super("学生课表管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        //设置布局
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        add(new LoginPanel(), "login");
        add(new MainPanel(), "main");
        add(new CourseSelectionPanel(courseManager.getCourseList()), "courseSelection");
        cardLayout.show(getContentPane(), "login");
        try {
            sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    class LoginPanel extends JPanel implements ActionListener, KeyListener {
        //初始化组件
        final JLabel titleLabel = new JLabel("欢迎进入学生课表管理系统");
        final JLabel usernameLabel = new JLabel("用户名");
        final JLabel passwordLabel = new JLabel("密码");
        final JTextField usernameField = new JTextField(20);
        final JPasswordField passwordField = new JPasswordField(20);
        final JButton loginButton = new JButton("登录");
        //用户名和密码
        String username;
        String password;
        public LoginPanel() {
            //设置布局
            setLayout(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();
            add(usernameLabel, constraints);
            constraints.gridx = 1;
            add(usernameField, constraints);
            constraints.gridy = 1;
            constraints.gridx = 0;
            add(passwordLabel, constraints);
            constraints.gridx = 1;
            add(passwordField, constraints);
            constraints.gridy = 2;
            constraints.gridx = 0;
            constraints.gridwidth = 2;
            add(loginButton, constraints);
            //设置监听器
            loginButton.addActionListener(this);
            loginButton.addKeyListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            username = usernameField.getText();
            password = passwordField.getText();
            if(studentService.isStudent(username, password)) {
                usernameField.setText("");
                passwordField.setText("");
                student = studentService.getStudent(username);
                cardLayout.show(getContentPane(), "main");
            }
            else if(username.equals("admin") && password.equals("admin")) {
                cardLayout.show(getContentPane(), "main");
            }
            else{
                JOptionPane.showMessageDialog(null, "用户名或密码错误");
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                loginButton.doClick();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    class MainPanel extends JPanel implements ActionListener{
        //初始化组件
        final JButton button = new JButton("注销");
        final JButton addCourseButton = new JButton("添加课程");
        JTable courseTable;
        public MainPanel() {
            //设置布局
            setLayout(new FlowLayout());
            add(button);
            button.addActionListener(this);
            add(addCourseButton);
            addCourseButton.addActionListener(this);
            //设置表格
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button){
                cardLayout.show(getContentPane(), "login");
            }
            else if(e.getSource() == addCourseButton){
                cardLayout.show(getContentPane(), "courseSelection");
            }
        }
    }
   class CourseSelectionPanel extends JPanel implements ActionListener{
       private JList<Course> courseList;
       public CourseSelectionPanel(ArrayList<Course> courses) {
           super(new BorderLayout());
           // 创建课程列表
           courseList = new JList<>(courses.toArray(new Course[0]));
           courseList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
           courseList.setLayoutOrientation(JList.VERTICAL);
           JScrollPane listScroller = new JScrollPane(courseList);
           listScroller.setPreferredSize(new Dimension(250, 80));

           // 创建选择按钮
           JButton selectButton = new JButton("Select");

           selectButton.addActionListener(e -> {
               // 获取用户选择的课程
               int[] selectedIndices = courseList.getSelectedIndices();
               ArrayList<Course> selectedCourses = new ArrayList<>();
               for (int i : selectedIndices) {
                   selectedCourses.add(courses.get(i));
               }
               // 打印选择的课程
               System.out.println("Selected courses:");
               for (Course course : selectedCourses) {
                   
               }
           });
           // 将列表和按钮添加到窗口中
           add(listScroller, BorderLayout.CENTER);
           add(selectButton, BorderLayout.SOUTH);
           getContentPane().add(this);
           pack();
           setVisible(true);
       }
       public void actionPerformed(ActionEvent e) {
           int[] selectedIndices = courseList.getSelectedIndices();
           ArrayList<Course> selectedCourses = new ArrayList<>();
           for (int i : selectedIndices) {
               selectedCourses.add(courseManager.getCourseList().get(i));
           }
           // 打印选择的课程
           System.out.println("Selected courses:");
           for (Course course : selectedCourses) {
                studentService.addCourseToStudent(student, course.getCourseName());
           }
       }
   }
    public static void main(String[] args) {
        new GUIView();
    }
}
