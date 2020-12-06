package com.lod.JuniorLib.model;

//import com.lod.JuniorLib.dbService.dataSets.Article;
//import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name= "tags")
public class Tag {
    @Id
    @GeneratedValue
//    @Column(name = "tag_id")
    private Long id;

//    @Column(name = "tag_name", unique=true, nullable=false)
    private String name;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "article",
//            joinColumns = { @JoinColumn(name = "tag_id") },
//            inverseJoinColumns = { @JoinColumn(name = "id") })
//    private Set<Article> articles = new HashSet<>();

    public Tag() {

    }

    public Tag(String name){//}, Set<Article> articles){
        this.name = name;
     //   this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public Set<Article> getArticles(){
//        return articles;
//    }
}
