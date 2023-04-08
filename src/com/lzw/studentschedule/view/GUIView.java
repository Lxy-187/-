package com.lzw.studentschedule.view;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class GUIView {
    @Test
    public void LoginView(){
        //登录界面
        JFrame frame = new JFrame("登录界面");
        // 设置窗口的大小
        frame.setSize(500, 300);
        // 设置窗口的关闭操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 创建一个面板
        JPanel panel = new JPanel();
        panel.add(new JLabel("用户名"));
        panel.add(new JButton("登录"));
        panel.add(new JTextField(10));
        panel.add(new JCheckBox());
        panel.add(new JMenu());

        // 添加面板到窗口
        frame.add(panel);
        // 显示窗口
        frame.setVisible(true);

        try{
            sleep(100000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
