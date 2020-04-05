package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface BookRepository {
    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);

    @Query("FROM Book WHERE status='REQUESTED'")
    List<Book> showRequested();

    @Query("FROM Book WHERE status='ISSUED'")
    List<Book> showIssued();

    @Query("FROM Book WHERE status='RETURNED'")
    List<Book> findAvailable();
}
