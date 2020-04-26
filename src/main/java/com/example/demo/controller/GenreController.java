package com.example.demo.controller;

import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Genre Controller")
@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("")
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Genre getGenreById(@PathVariable("Id") Long Id) {
        return genreRepository.findById(Id).get();
    }

    @GetMapping("/find/")
    public List<Genre> getGenreByName(@RequestParam String type) {
        return genreRepository.findByType(type);
    }

    @PostMapping("")
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.saveAndFlush(genre);
    }

    @DeleteMapping("/{Id}")
    public Genre deleteGenre(@PathVariable("Id") Long Id) {
        genreRepository.deleteById(Id);
        return genreRepository.saveAndFlush(genreRepository.findById(Id).get());
    }

    @PutMapping("/{Id}")
    public Genre updateGenre(@PathVariable Long Id, @RequestBody Genre genre) {
        //   genre.setId(Id);
        return genreRepository.saveAndFlush(genre);
    }

}