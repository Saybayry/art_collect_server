package com.example.demo.art.service;

import com.example.demo.art.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.demo.art.model.Tag;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> findAll(){
        return tagRepository.findAll();
    }

    public Optional<Tag> findById(Long id){
        return tagRepository.findById(id);
    }

    public Tag save(Tag tag){
        return tagRepository.save(tag);
    }

    public void deleteById(Long id){
        tagRepository.deleteById(id);
    }


}