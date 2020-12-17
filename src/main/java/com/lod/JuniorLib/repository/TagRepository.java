package com.lod.JuniorLib.repository;

import com.lod.JuniorLib.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findByName(String name);
}
