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

    @Override
    public String toString() {
        return "BookCollection{" +
                "Id=" + Id +
                ", author='" + author + '\'' +
                ", books=" + books +
                '}';
    }
}
