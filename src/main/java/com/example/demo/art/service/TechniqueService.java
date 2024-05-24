package com.example.demo.art.service;

import com.example.demo.art.repository.TechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.demo.art.model.Technique;

@Service
public class TechniqueService {
    @Autowired
    private TechniqueRepository techniqueRepository;

    public List<Technique> findAll(){
        return techniqueRepository.findAll();
    }

    public Optional<Technique> findById(Long id){
        return techniqueRepository.findById(id);
    }

    public Technique save(Technique technique){
        return techniqueRepository.save(technique);
    }

    public void deleteById(Long id){
        techniqueRepository.deleteById(id);
    }


}