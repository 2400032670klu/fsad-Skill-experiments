package com.indra.library.controller;

import com.indra.library.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    private List<Book> books = new ArrayList<>();

    public LibraryController() {
        books.add(new Book(1, "Data Structures", "Mark Allen", 300));
        books.add(new Book(2, "Spring Basics", "Rod Johnson", 250));
        books.add(new Book(3, "Microservices", "Martin Fowler", 400));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Indra Library System";
    }

    @GetMapping("/count")
    public int count() {
        return books.size();
    }

    @GetMapping("/price")
    public double price() {
        return 299.50;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching book: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Author name: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added successfully!";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return books;
    }
}