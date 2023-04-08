package com.lzw.studentschedule.utils;
import java.io.Console;
public class MyUtils {
    public static String getInputString(int length){
        //获取用户输入，length为输入的长度
        String input = "";
        while (input.length() != length){
            input = new java.util.Scanner(System.in).nextLine();
            if (input.length() != length){
                System.out.println("输入长度不正确，请重新输入");
            }
        }
        return input;
    }
    public static int getInputInt(int lowerBound, int upperBound) {
        //获取用户输入，a,b为输入的范围
        try {
            int input = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
            if (input >= lowerBound && input <= upperBound) {
                return input;
            } else {
                System.out.print("输入范围不正确，请重新输入:");
                return getInputInt(lowerBound, upperBound);
            }
        } catch (Exception e) {
            System.out.print("输入类型不正确，请重新输入:");
            return getInputInt(lowerBound, upperBound);
        }
    }

    public static String readPassword(String prompt){
        Console console = System.console();
        char[] password = console.readPassword(prompt);
        return new String(password);
    }
}
