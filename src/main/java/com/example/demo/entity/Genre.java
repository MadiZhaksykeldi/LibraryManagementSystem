package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Genre{" +
                "Id=" + Id +
                ", type='" + type + '\'' +
                ", bList=" + bList +
                '}';
    }
}