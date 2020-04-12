package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_genres",
            joinColumns = {@JoinColumn(name = "gId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name = "bId", referencedColumnName = "Id")}
    )

    private List<Book> bList;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "Id=" + Id +
                ", type='" + type + '\'' +
                ", bList=" + bList +
                '}';
    }
}