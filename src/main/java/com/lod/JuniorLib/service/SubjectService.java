package com.lod.JuniorLib.service;

import com.lod.JuniorLib.model.Subject;
import com.lod.JuniorLib.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public SubjectService(){}

    public void create(String name) {
        Subject subject = new Subject(name);
        subjectRepository.save(subject);
    }

    public Iterable<Subject> listAllSubjects() {
        //  return base.findAllArticles();
        return subjectRepository.findAll();
    }

    public Subject find(Long subjectId){
        if(subjectRepository.findById(subjectId).isPresent())
            return subjectRepository.findById(subjectId).get();
        return null;
    }

    public void remove(Long subjectId){
        // base.deleteArticle(id);
        subjectRepository.deleteById(subjectId);
    }
}
