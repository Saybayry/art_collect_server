package com.example.demo.art.model;

import com.example.demo.user.model.User;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
public class Art {


//    @Autowired
//    ArtistService artistService;
//    @Autowired
//    ArtMovementService artMovementService;
//    @Autowired
//    TechniqueService techniqueService;

    public Art() {
        // Пустой конструктор
    }
    public Art(String name, Genre genre, ArtMovement artMovement, Technique technique, Artist artist, Date creationDate, Long size, String tags, String imageName, User owner) {
        this.name = name;
        this.genre = genre;
        this.artMovement = artMovement;
        this.technique = technique;
        this.artist = artist ;
        this.creationDate = creationDate;
        this.size = size;
        this.owner = owner;
//        this.tags = tags;
        this.imagePath = imageName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Genre genre;

    @ManyToOne
    @JoinColumn(nullable = true)
    private ArtMovement artMovement;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Technique technique;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Artist artist;

    @Temporal(TemporalType.DATE)
    @JoinColumn(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    @JoinColumn(nullable = true)
    @Column(precision = 8, scale = 8)
    private Long size;

    @ManyToMany
    @JoinTable(
            name = "Art_Tag",
            joinColumns = @JoinColumn(name = "art_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();


    @JoinColumn(nullable = true)
    @Column(name = "image_path")
    private String imagePath;

    @JoinColumn(nullable = true)
    private Integer price;

    @JoinColumn(nullable = true)
    private Integer popularity;
    @ManyToOne
    @JoinColumn(nullable = true)
    private User owner;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ArtMovement getArtMovement() {
        return artMovement;
    }

    public void setArtMovement(ArtMovement artMovement) {
        this.artMovement = artMovement;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


//    @ManyToOne
////    @JoinColumn(name = "Сollection")
////    private Collection collection;

    // Getters and setters
}
