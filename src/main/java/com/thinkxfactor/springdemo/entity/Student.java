package com.thinkxfactor.springdemo.entity;

import java.util.HashMap;

public class Student {

    private String name;
    private String address;
    private int age;
    private String gender;
    private int rollNo;
    private String department;

    public Student(String name, String address, String department, int rollNo, int age, String gender) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.rollNo = rollNo;
        this.department = department;
    }

    public HashMap<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("department", department);
        data.put("rollNo", rollNo);
        data.put("age", age);
        data.put("address", address);
        data.put("gender", gender);
        return data;
    }

    public int getRollNo() {
        return rollNo;
    }

}