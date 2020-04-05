package com.example.demo.entity;

import com.example.demo.entity.Book;

import javax.persistence.*;
import java.util.List;

@Entity
public class LibraryMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_books", joinColumns = {@JoinColumn(name = "mId", referencedColumnName = "Id")}, inverseJoinColumns = {@JoinColumn(name = "bId", referencedColumnName = "Id")}
    )
    private List<Book> bList;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getbList() {
        return bList;
    }

    public void setbList(List<Book> bList) {
        this.bList = bList;
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", bList=" + bList +
                '}';
    }
}