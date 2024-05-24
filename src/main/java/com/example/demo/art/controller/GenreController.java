package com.example.demo.art.controller;

import com.example.demo.art.model.Genre;
import com.example.demo.art.model.Tag;
import com.example.demo.art.service.GenreService;
import com.example.demo.art.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/genre")
@CrossOrigin
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenres(){
        return genreService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Genre> getGenreById(@PathVariable Long id) {
        return genreService.findById(id);
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre tag) {
        return genreService.save(tag);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable Long id, @RequestBody Genre tag) {
        tag.setId(id);
        return genreService.save(tag);
    }

    @DeleteMapping("/{id}")
    public void deleteGenreById(@PathVariable Long id) {
        genreService.deleteById(id);
    }

}
