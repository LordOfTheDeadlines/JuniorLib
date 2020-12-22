package com.lod.JuniorLib.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @ManyToMany(
//            targetEntity=Tag.class,
//            cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(
//            name="article_tags",
//            joinColumns={@JoinColumn(name="tag_id")},
//            inverseJoinColumns={@JoinColumn(name="article_id")}
//    )
//    private Set<Tag> articles = new HashSet<>();

    public Tag() {

    }

    public Tag(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setArticles(Set<Tag> articles) {
//        this.articles = articles;
//    }
//
//    public Set<Tag> getArticles() {
//        return articles;
//    }
}
