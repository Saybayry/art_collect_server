package com.example.demo.art.repository;

import com.example.demo.art.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    // Метод для поиска по имени
    List<Artist> findByFirstName(String firstName);

    // Метод для поиска по фамилии
    List<Artist> findByLastName(String lastName);

    // Метод для поиска по имени или фамилии
    List<Artist> findByFirstNameOrLastName(String firstName, String lastName);

    // Метод для поиска по имени, фамилии или отчеству
    List<Artist> findByFirstNameOrLastNameOrOtherName(String firstName, String lastName, String otherName);

    // Метод для поиска по имени и фамилии
    List<Artist> findByFirstNameAndLastName(String firstName, String lastName);

    // Дополнительно, можно добавить метод для поиска по дате рождения
    List<Artist> findByDateOfBirth(Date dateOfBirth);
}
