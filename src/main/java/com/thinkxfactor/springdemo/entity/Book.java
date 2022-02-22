package com.thinkxfactor.springdemo.entity;

public class Book {
    private String name;
    private String ISBN;

    public Book(String name, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }
}
