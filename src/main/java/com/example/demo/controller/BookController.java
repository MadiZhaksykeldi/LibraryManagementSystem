package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookTransactionStatus;
import com.example.demo.entity.LibraryMember;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Scanner;

public class BookController {
    @PersistenceContext
    private EntityManager entityManager;

    public String request() {
        System.out.println("Enter book title to request: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public void borrowBook(Long cId, Long bId) {
        LibraryMember member = entityManager.find(LibraryMember.class, cId);
        Book book = entityManager.find(Book.class, bId);
        if (book.getBookTransactionStatus().equals("RETURNED")) {
            book.setBookTransactionStatus(BookTransactionStatus.ISSUED);
        } else {
            System.out.println("Book is currently not available!");
        }
    }

    public void showDetails(List<?> entities, String message) {
        System.out.println("-----" + message + "-----");
        for (Object entity : entities) {
            System.out.println(entity);
        }
        System.out.println("-------------------------");
    }

   /* public void clear(Long bId){
        for(entityManager.find(Book.class, bId)){

        }
    }*/
}