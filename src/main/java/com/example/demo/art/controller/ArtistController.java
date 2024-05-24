package com.example.demo.art.controller;


import com.example.demo.art.model.Artist;
import com.example.demo.art.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artist")
@CrossOrigin
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Artist> getArtistById(@PathVariable Long id) {
        return artistService.findById(id);
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.save(artist);
    }

    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        artist.setId(id);
        return artistService.save(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtistById(@PathVariable Long id) {
        artistService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Artist> searchArtists(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String otherName,
            @RequestParam(required = false) Date dateOfBirth) {

        if (firstName != null && lastName != null && otherName != null) {
            return artistService.findByFirstNameOrLastNameOrOtherName(firstName, lastName, otherName);
        } else if (firstName != null && lastName != null) {
            return artistService.findByFirstNameAndLastName(firstName, lastName);
        } else if (firstName != null) {
            return artistService.findByFirstName(firstName);
        } else if (lastName != null) {
            return artistService.findByLastName(lastName);
        } else if (dateOfBirth != null) {
            return artistService.findByDateOfBirth(dateOfBirth);
        } else {
            return artistService.findAll();
        }
    }


}
