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
public class LibraryMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_books", joinColumns = {@JoinColumn(name = "mId", referencedColumnName = "Id")}, inverseJoinColumns = {@JoinColumn(name = "bId", referencedColumnName = "Id")}
    )
    private List<Book> bList;

    @Override
    public String toString() {
        return "LibraryMember{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", bList=" + bList +
                '}';
    }
}