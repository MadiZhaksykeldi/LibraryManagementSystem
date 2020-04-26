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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String author;

    @ManyToMany(mappedBy = "booksgenre", fetch = FetchType.LAZY)
    private List<Genre> genreList;
    @Enumerated(EnumType.STRING)
    private BookTransactionStatus bookTransactionStatus;
    @ManyToMany(mappedBy = "bList", fetch = FetchType.LAZY)
    private List<LibraryMember> libraryMemberList;
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<BookCollection> bookCollections;

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genreList=" + genreList +
                ", bookTransactionStatus=" + bookTransactionStatus +
                ", libraryMemberList=" + libraryMemberList +
                ", bookCollections=" + bookCollections +
                '}';
    }
}
