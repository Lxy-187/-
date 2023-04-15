package com.lzw.studentschedule.view;

import com.lzw.studentschedule.service.CourseService;
import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;

public class GUIView extends JFrame {
    private CardLayout cardLayout;
    private CourseService courseService = new CourseService();
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
            if(courseService.login(username, password).equals("user")) {
                usernameField.setText("");
                passwordField.setText("");
                cardLayout.show(getContentPane(), "main");
            }
            else if(courseService.login(username, password).equals("admin")) {
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
        JTable courseTable;
        public MainPanel() {
            //设置布局
            setLayout(new FlowLayout());
            add(button);
            button.addActionListener(this);
            String[] columnNames = {"节次", "星期一", "星期二", "星期三", "星期四", "星期五"};
            Object[][] rowData = {
                    {"1：8~9", "语文", "数学", "英语", "物理", "化学"},
                    {"2：9~10", "语文", "数学", "英语", "物理", "化学"},
                    {"3：10~11", "语文", "数学", "英语", "物理", "化学"},
                    {"4：11~12", "语文", "数学", "英语", "物理", "化学"},
                    {"5：13~14", "语文", "数学", "英语", "物理", "化学"},
                    {"6：14~15", "语文", "数学", "英语", "物理", "化学"},
                    {"7：15~16", "语文", "数学", "英语", "物理", "化学"},
                    {"8：16~17", "语文", "数学", "英语", "物理", "化学"},
                    {"9：17~18", "语文", "数学", "英语", "物理", "化学"},
            };
            courseTable = new JTable(rowData, columnNames);
            JScrollPane scrollPane = new JScrollPane(courseTable);
            add(scrollPane);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(getContentPane(), "login");
        }
    }
    @Test
    public void test(){
        new GUIView();
    }
}
