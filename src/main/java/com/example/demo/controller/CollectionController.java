package com.example.demo.controller;

import com.example.demo.entity.BookCollection;
import com.example.demo.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {
    @Autowired
    private CollectionRepository collectionRepository;

    @GetMapping("")
    public List<BookCollection> getAllCollections() {
        return collectionRepository.findAll();
    }

    @GetMapping("/{Id}")
    public BookCollection getCollectionById(@PathVariable("Id") Long Id) {
        return collectionRepository.findById(Id).get();
    }

    @GetMapping("/find_author/")
    public List<BookCollection> getCollectionByAuthor(@RequestParam String author) {
        return collectionRepository.findByAuthor(author);
    }

    @PostMapping("")
    public BookCollection createCollection(@RequestBody BookCollection c) {
        return collectionRepository.saveAndFlush(c);
    }

    @DeleteMapping("/{Id}")
    public BookCollection deleteCollection (@PathVariable("Id") Long Id) {
        collectionRepository.deleteById(Id);
        return collectionRepository.saveAndFlush(collectionRepository.findById(Id).get());
    }


    @PutMapping("/{Id}")
    public BookCollection updateCollection(@PathVariable Long Id, @RequestBody BookCollection bookCollection) {
        bookCollection.setId(Id);
        return collectionRepository.saveAndFlush(bookCollection);
    }
}
