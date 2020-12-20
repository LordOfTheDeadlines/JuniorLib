package com.lod.JuniorLib.repository;

import com.lod.JuniorLib.model.Article;
import com.lod.JuniorLib.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findBySubjectName(String subject);
    List<Article> findByTagsIn(List<Long> tagsId);
}
