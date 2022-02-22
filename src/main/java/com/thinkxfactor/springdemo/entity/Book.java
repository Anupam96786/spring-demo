package com.thinkxfactor.springdemo.entity;

import java.util.HashMap;

public class Book {
    private String name;
    private String ISBN;

    public Book(String name, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
    }

    public HashMap<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("ISBN", ISBN);
        return data;
    }

    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }
}
