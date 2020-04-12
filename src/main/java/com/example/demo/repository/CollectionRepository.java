package com.example.demo.repository;

import com.example.demo.entity.BookCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<BookCollection, Long> {
    List<BookCollection> findByAuthor(String author);
}
