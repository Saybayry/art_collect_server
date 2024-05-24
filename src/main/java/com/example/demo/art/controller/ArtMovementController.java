package com.example.demo.art.controller;

import com.example.demo.art.model.ArtMovement;
import com.example.demo.art.model.Genre;
import com.example.demo.art.service.ArtMovementService;
import com.example.demo.art.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/art_movement")
@CrossOrigin
public class ArtMovementController {
    @Autowired
    private ArtMovementService artMovementService;

    @GetMapping
    public List<ArtMovement> getAllArtMovements(){
        return artMovementService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<ArtMovement> getArtMovementById(@PathVariable Long id) {
        return artMovementService.findById(id);
    }

    @PostMapping
    public ArtMovement createArtMovement(@RequestBody ArtMovement artMovement) {
        return artMovementService.save(artMovement);
    }

    @PutMapping("/{id}")
    public ArtMovement updateArtMovement(@PathVariable Long id, @RequestBody ArtMovement artMovement) {
        artMovement.setId(id);
        return artMovementService.save(artMovement);
    }

    @DeleteMapping("/{id}")
    public void deleteArtMovementById(@PathVariable Long id) {
        artMovementService.deleteById(id);
    }

}
