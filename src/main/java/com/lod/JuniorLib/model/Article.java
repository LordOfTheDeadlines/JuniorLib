package com.lod.JuniorLib.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @ManyToMany(
//            targetEntity=Article.class,
//            cascade = { CascadeType.ALL }
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH }
            )
    @JoinTable(
            name="article_tags",
            joinColumns={@JoinColumn(name="article_id")},
            inverseJoinColumns={@JoinColumn(name="tag_id")}
    )
    private Set<Tag> tags = new HashSet<>();

    public Article(){

    }

    public Article(String title, String content, Subject subject, String tagsStr){
        this.title = title;
        this.content = content;
        this.subject = subject;
        this.tags = parseTags(tagsStr);
    }

    public Article(String title, String content, String subjectName){
        this.title = title;
        this.content = content;
        this.subject = new Subject(subjectName);
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public Subject getSubject(){
        return subject;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Set<Tag> parseTags(String tagsStr){
       String[] tags = tagsStr.split(" ");
       HashSet<Tag> result = new HashSet<>();
       for(String tag:tags){
           result.add(new Tag(tag));
       }
       return result;
    }
}

