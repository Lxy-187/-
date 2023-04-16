package com.lzw.studentschedule.domain;

public class Admin implements User {
    private String username;
    private String password;
    public Admin(String username, String password, String role){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return "Admin";
    }
}
