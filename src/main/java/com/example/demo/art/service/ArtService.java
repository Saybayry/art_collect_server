package com.example.demo.art.service;

import com.example.demo.art.model.Art;
import com.example.demo.art.model.Artist;
import com.example.demo.art.repository.ArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtService {

    @Autowired
    private ArtRepository artRepository;

    public List<Art> findAll() {
        return artRepository.findAll();
    }

    public Optional<Art> findById(Long id) {
        return artRepository.findById(id);
    }

    public Art save(Art art) {
        return artRepository.save(art);
    }

    public void deleteById(Long id) {
        artRepository.deleteById(id);
    }

    public List<Art> findByArtist(Artist artist) {
        return artRepository.findByArtist(artist);
    }

    public Art saveArt(Art art) {
        return artRepository.save(art);
    }
    // Другие методы сервиса, если необходимо
}
