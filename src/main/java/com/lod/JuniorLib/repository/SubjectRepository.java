package com.lod.JuniorLib.repository;

import com.lod.JuniorLib.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
    Subject findByName(String name);
}
