package com.example.demo.art.service;

import com.example.demo.art.repository.ArtMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.demo.art.model.ArtMovement;
@Service
public class ArtMovementService {
    @Autowired
    private ArtMovementRepository artMovementRepository;

    public List<ArtMovement> findAll(){
        return artMovementRepository.findAll();
    }

    public Optional<ArtMovement> findById(Long id){
        return artMovementRepository.findById(id);
    }

    public ArtMovement save(ArtMovement artMovement){
        return artMovementRepository.save(artMovement);
    }

    public void deleteById(Long id){
        artMovementRepository.deleteById(id);
    }


}
