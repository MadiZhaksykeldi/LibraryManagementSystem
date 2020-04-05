package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String author;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Genre> genres;
    @Enumerated(EnumType.STRING)
    private BookTransactionStatus bookTransactionStatus;
    @ManyToMany(mappedBy = "bList", fetch = FetchType.LAZY)
    private List<LibraryMember> libraryMemberList;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public BookTransactionStatus getBookTransactionStatus() {
        return bookTransactionStatus;
    }

    public void setBookTransactionStatus(BookTransactionStatus bookTransactionStatus) {
        this.bookTransactionStatus = bookTransactionStatus;
    }

    public List<LibraryMember> getLibraryMemberList() {
        return libraryMemberList;
    }

    public void setLibraryMemberList(List<LibraryMember> libraryMemberList) {
        this.libraryMemberList = libraryMemberList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genres=" + genres +
                ", bookTransactionStatus=" + bookTransactionStatus +
                ", libraryMemberList=" + libraryMemberList +
                '}';
    }
}
