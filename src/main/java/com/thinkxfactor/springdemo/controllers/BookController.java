package com.thinkxfactor.springdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

import com.thinkxfactor.springdemo.entity.Book;

@RestController
@RequestMapping("/books")
public class BookController {
    private static ArrayList<HashMap> books = generateBooks();

    private static ArrayList<HashMap> generateBooks() {
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        books.add(new Book("Book A", "12345").getData());
        books.add(new Book("Book B", "12346").getData());
        books.add(new Book("Book C", "12347").getData());
        books.add(new Book("Book D", "12348").getData());
        books.add(new Book("Book E", "12349").getData());
        books.add(new Book("Book F", "12350").getData());
        return books;
    }

    @GetMapping("/get-all-books")
    public ArrayList<HashMap> getAllBooks() {
        return books;
    }

    @PostMapping("/add-book")
    public HashMap addBook(@RequestBody Book book) {
        books.add(book.getData());
        return book.getData();
    }

    @GetMapping("/get-by-isbn/{isbn}")
    public HashMap getByISBN(@PathVariable String isbn) {
        for (HashMap book : books) {
            if (book.get("ISBN").equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @GetMapping("/delete-by-isbn/{isbn}")
    public HashMap deleteByISBN(@PathVariable String isbn) {
        for (HashMap book : books) {
            if (book.get("ISBN").equals(isbn)) {
                books.remove(book);
                return book;
            }
        }
        return null;
    }
}
