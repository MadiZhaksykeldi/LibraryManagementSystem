package com.example.demo.entity;

import com.example.demo.entity.Book;

import javax.persistence.*;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String type;

    @Column(name = "bId")
    private Long bId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bId", insertable = false, updatable = false)
    private Book book;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public java.lang.Long getbId() {
        return bId;
    }

    public void setbId(java.lang.Long bId) {
        this.bId = bId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "type='" + type + '\'' +
                ", bId=" + bId +
                ", book=" + book +
                '}';
    }
}