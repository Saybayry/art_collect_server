package com.example.demo.art.service;

import com.example.demo.art.model.Artist;
import com.example.demo.art.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }

    // Метод для поиска по имени
    public List<Artist> findByFirstName(String firstName) {
        return artistRepository.findByFirstName(firstName);
    }

    // Метод для поиска по фамилии
    public List<Artist> findByLastName(String lastName) {
        return artistRepository.findByLastName(lastName);
    }

    // Метод для поиска по имени или фамилии
    public List<Artist> findByFirstNameOrLastName(String firstName, String lastName) {
        return artistRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    // Метод для поиска по имени, фамилии или отчеству
    public List<Artist> findByFirstNameOrLastNameOrOtherName(String firstName, String lastName, String otherName) {
        return artistRepository.findByFirstNameOrLastNameOrOtherName(firstName, lastName, otherName);
    }

    // Метод для поиска по имени и фамилии
    public List<Artist> findByFirstNameAndLastName(String firstName, String lastName) {
        return artistRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    // Метод для поиска по дате рождения
    public List<Artist> findByDateOfBirth(Date dateOfBirth) {
        return artistRepository.findByDateOfBirth(dateOfBirth);
    }
}
