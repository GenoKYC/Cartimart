package com.example.cartimart;

public class UsersInfo {
    private String full_name;
    private String email_address;
    private String password;


    public UsersInfo(String full_name, String email_address, String password){
        this.full_name = full_name;
        this.email_address = email_address;
        this.password = password;
    }
    //getter

    public String getFull_name() {return full_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getPassword() {
        return password;
    }

    //setter


    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}