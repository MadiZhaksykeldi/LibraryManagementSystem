package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Book getBookById(@PathVariable("Id") Long Id) {
        return bookRepository.findById(Id).get();
    }

    @GetMapping("/find_title/")
    public List<Book> getBookByTitle(@RequestParam String title) {
        return bookRepository.findByTitle(title);
    }

    @GetMapping("/find_author/")
    public List<Book> getBookByAuthor(@RequestParam String author) {
        return bookRepository.findByAuthor(author);
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @DeleteMapping("/{Id}")
    public Book deleteBook(@PathVariable("Id") Long Id) {
        bookRepository.deleteById(Id);
        return bookRepository.saveAndFlush(bookRepository.findById(Id).get());
    }

    @PutMapping("/{Id}")
    public Book updateBook(@PathVariable Long Id, @RequestBody Book book) {
        book.setId(Id);
        return bookRepository.saveAndFlush(book);
    }
}