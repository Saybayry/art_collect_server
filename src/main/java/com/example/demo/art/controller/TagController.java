package com.example.demo.art.controller;

import com.example.demo.art.model.Tag;
import com.example.demo.art.model.Technique;
import com.example.demo.art.service.TagService;
import com.example.demo.art.service.TechniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/tag")
@CrossOrigin
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public List<Tag> getAllTags(){
        return tagService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Tag> getTagById(@PathVariable Long id) {
        return tagService.findById(id);
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        tag.setId(id);
        return tagService.save(tag);
    }

    @DeleteMapping("/{id}")
    public void deleteTagById(@PathVariable Long id) {
        tagService.deleteById(id);
    }

}
