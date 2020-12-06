package com.lod.JuniorLib.service;

//import com.lod.JuniorLib.dbService.DBService;
//import com.lod.JuniorLib.dbService.dataSets.Article;
import com.lod.JuniorLib.model.Article;
import com.lod.JuniorLib.model.Subject;
import com.lod.JuniorLib.repository.ArticleRepository;
import com.lod.JuniorLib.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArticleService {

//    private static Map<String, Article> sessionBase = new HashMap<>();
//    private DBService base = new DBService();

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public ArticleService(){

    }

    public void create(String title, String content, String subject) {
        Article article = new Article(title, content, subject);
        articleRepository.save(article);
        subjectRepository.save(new Subject(subject));
    }

    public Iterable<Article> listAllArticles() {
      //  return base.findAllArticles();
        return articleRepository.findAll();
    }

    public Article find(Long productId){
        if(articleRepository.findById(productId).isPresent())
            return articleRepository.findById(productId).get();
        return null;
    }

    public Iterable<Article> findBySubject(String subject){
        return articleRepository.findBySubject(subject);
    }

    public void remove(Long id){
       // base.deleteArticle(id);
        articleRepository.deleteById(id);
    }

//    public boolean checkSessionId(String sessionID){
//        return sessionBase.containsKey(sessionID);
//    }

    public boolean quit(String sessionID){
//        if(sessionBase.containsKey(sessionID)){
//            sessionBase.remove(sessionID);
//            return true;
//        }
        return false;
    }
}