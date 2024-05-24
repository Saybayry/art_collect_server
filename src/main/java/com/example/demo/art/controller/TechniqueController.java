package com.example.demo.art.controller;

import com.example.demo.art.service.TechniqueService;
import com.example.demo.art.model.Technique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/technique")
@CrossOrigin
public class TechniqueController {
    @Autowired
    private TechniqueService techniqueService;

    @GetMapping
    public List<Technique> getAllTechniques(){
        return techniqueService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Technique> getTechniqueById(@PathVariable Long id) {
        return techniqueService.findById(id);
    }

    @PostMapping
    public Technique createTechnique(@RequestBody Technique note) {
        return techniqueService.save(note);
    }

    @PutMapping("/{id}")
    public Technique updateTechnique(@PathVariable Long id, @RequestBody Technique note) {
        note.setId(id);
        return techniqueService.save(note);
    }

    @DeleteMapping("/{id}")
    public void deleteTechniqueById(@PathVariable Long id) {
        techniqueService.deleteById(id);
    }



}
