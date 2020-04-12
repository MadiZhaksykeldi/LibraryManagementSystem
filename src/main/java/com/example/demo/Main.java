package com.example.demo;


import com.example.demo.config.SpringConfiguration;
import com.example.demo.controller.BookController;
import com.example.demo.controller.MemberController;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookTransactionStatus;
import com.example.demo.entity.Genre;
import com.example.demo.entity.LibraryMember;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.GenreRepository;
import com.example.demo.repository.LibraryMemberRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        LibraryMember member = new LibraryMember();
//        MemberController mc = new MemberController();
//
//        Genre detective = new Genre();
//        Genre science = new Genre();
//        Genre drama = new Genre();
//        drama.setType("Drama");
//        science.setType("Science");
//        detective.setType("Detective");
//        GenreRepository gr = context.getBean("genreRepository", GenreRepository.class);
//        gr.saveAndFlush(drama);
//        List<Genre> list1 = new ArrayList<Genre>();
//        List<Genre> list2 = new ArrayList<Genre>();
//        List<Genre> list3 = new ArrayList<Genre>();
//        list1.add(detective);
//        list2.add(science);
//        list3.add(drama);
//
//        Book book = new Book();
//        book.setAuthor("J.R Tolkien");
//        book.setTitle("Lord Of The Rings");
//        book.setGenres(list1);
//        book.setBookTransactionStatus(BookTransactionStatus.RETURNED);
//
//        BookRepository br = context.getBean("bookRepository", BookRepository.class);
//
//        List<Book> bList = new ArrayList<Book>();
//        BookController bc = new BookController();
//        bList.add(book);
//        member.setbList(bList);
//
//        System.out.println("Enter book title to search: ");
//        Scanner sc = new Scanner(System.in);
//        String bookTitle = sc.nextLine();
//        System.out.println("\nFound books: " + br.findByTitle(bookTitle));
//
//        System.out.println("Enter book author to search: ");
//        String bookAuthor = sc.nextLine();
//        System.out.println("\nFound books: " + br.findByTitle(bookAuthor));
//
//        System.out.println("Show all available books: ");
//        System.out.println("\nFound books: " + br.findAvailable());
//
//        LibraryMemberRepository mr = context.getBean("libraryMemberRepository", LibraryMemberRepository.class);
//        System.out.println("------" + member.toString());
//        mr.saveAndFlush(member);
    }
}