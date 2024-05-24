package com.example.demo.art.repository;

import com.example.demo.art.model.ArtMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtMovementRepository extends JpaRepository<ArtMovement, Long> {
}
