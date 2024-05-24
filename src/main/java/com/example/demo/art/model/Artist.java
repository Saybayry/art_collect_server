package com.example.demo.art.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = true)
    private String otherName;
    @Column(nullable = true)
    private Date dateOfBirth;


    public Artist() {
    }
    /**
     * Parameterized constructor.
     *
     * @param firstName the first name of the artist
     * @param lastName the last name of the artist
     * @param otherName the other name of the artist (optional)
     * @param dateOfBirth the date of birth of the artist (optional)
     */
    public Artist(String firstName, String lastName, String otherName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", otherName='" + otherName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

