package com.lod.JuniorLib.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "subject")
public class Subject {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Subject(){

    }

    public Subject(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    @OneToMany(mappedBy = "subject", cascade=CascadeType.ALL, orphanRemoval = true)
    private Set<Article> articles;
}
