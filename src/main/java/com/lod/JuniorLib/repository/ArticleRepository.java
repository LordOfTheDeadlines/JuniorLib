package com.lod.JuniorLib.repository;

import com.lod.JuniorLib.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findBySubjectName(String subject);
//    @Query(value="select a.id, a.name, a.id_subject from article a inner join article_tags atag on a.id = atag.article_id and atag.tag_id in (:tagsId)"
//    )
//    List<Article> findByTagsIn(@Param("tagsId")List<Long> tagsId);
//List<Article> findByTagName(String tag);
}
