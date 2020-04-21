package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "collection",
            joinColumns = {@JoinColumn(name = "cId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name = "bId", referencedColumnName = "Id")}
    )

    private List<Book> books;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "BookCollection{" +
                "Id=" + Id +
                ", author='" + author + '\'' +
                ", books=" + books +
                '}';
    }
}
