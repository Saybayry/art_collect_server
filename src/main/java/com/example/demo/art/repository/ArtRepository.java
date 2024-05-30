package com.example.demo.art.repository;

import com.example.demo.art.model.Art;
import com.example.demo.art.model.Artist;
import com.example.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtRepository extends JpaRepository<Art, Long> {
    List<Art> findByArtist(Artist artist);
    List<Art> findByOwner(User owner);

    // Можно добавить собственные методы запросов, если это необходимо
}
