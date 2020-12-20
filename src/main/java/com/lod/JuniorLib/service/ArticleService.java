package com.lod.JuniorLib.service;

import com.lod.JuniorLib.model.Article;
import com.lod.JuniorLib.model.Subject;
import com.lod.JuniorLib.model.Tag;
import com.lod.JuniorLib.repository.ArticleRepository;
import com.lod.JuniorLib.repository.SubjectRepository;
import com.lod.JuniorLib.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TagRepository tagRepository;

    public ArticleService(){

    }

    public void create(String title, String content, String subjectName, String tagsStr) {
        Subject subject = new Subject(subjectName);
        Subject subjectFromDB = subjectRepository.findByName(subjectName);
        if(subjectFromDB==null){
            subjectRepository.save(subject);
        }
        else subject = subjectFromDB;
        Article article = new Article(title, content, subject, tagsStr);
        articleRepository.save(article);
    }

    public Iterable<Article> listAllArticles() {
        return articleRepository.findAll();
    }

    public Article find(Long productId){
        if(articleRepository.findById(productId).isPresent())
            return articleRepository.findById(productId).get();
        return null;
    }

    public Iterable<Article> findBySubject(String subject){
        return articleRepository.findBySubjectName(subject);
    }

    public Iterable<Article> findByTagsList(List<Long> tagsId){
        return articleRepository.findByTagsIn(tagsId);
    }

    public void remove(Long id){
        articleRepository.deleteById(id);
    }
}
