package com.thinkxfactor.springdemo.entity;

import java.util.HashMap;

public class Admin {
    private String name;
    private String username;
    private String password;

    public Admin(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public HashMap getData() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name", this.name);
        data.put("username", this.username);
        data.put("password", this.password);
        return data;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
