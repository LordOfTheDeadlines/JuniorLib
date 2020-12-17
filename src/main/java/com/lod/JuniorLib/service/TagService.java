package com.lod.JuniorLib.service;

import com.lod.JuniorLib.model.Subject;
import com.lod.JuniorLib.model.Tag;
import com.lod.JuniorLib.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public TagService(){

    }

    public void create(String name) {
        Tag tag = new Tag(name);
        tagRepository.save(tag);
    }

    public Iterable<Tag> listAllTags() {
        return tagRepository.findAll();
    }

    public Tag find(Long tagId){
        if(tagRepository.findById(tagId).isPresent())
            return tagRepository.findById(tagId).get();
        return null;
    }
}
