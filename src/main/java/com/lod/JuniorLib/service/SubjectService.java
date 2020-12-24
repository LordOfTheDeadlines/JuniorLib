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

    public Subject create(String name) {
        Subject subject = new Subject(name);
        Subject subjectFromDB = subjectRepository.findByName(name);
        if(subjectFromDB==null)
            return subjectRepository.save(subject);
        return subjectFromDB;
    }

    public Iterable<Subject> listAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject find(Long subjectId){
        if(subjectRepository.findById(subjectId).isPresent())
            return subjectRepository.findById(subjectId).get();
        return null;
    }

    public void remove(Long subjectId){
        subjectRepository.deleteById(subjectId);
    }
}
