package com.lod.JuniorLib.model;

import com.sun.istack.NotNull;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.mapping.Join;
import org.springframework.lang.NonNull;

import javax.persistence.*;

//import org.hibernate.validator.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name= "article")
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NonNull
//    @Column(name = "id")
    private Long id;

//    @Column(name = "title", unique=true, nullable=false)
    @NotNull
    private String title;

//    @Column(name = "content", unique=true, nullable=false)
    @NotNull
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="subject_id")
    private Subject subject;

    public Article(){

    }

    public Article(String title, String content, Subject subject){
        this.title = title;
        this.content = content;
        this.subject = subject;
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

//    public Set<Tag> getTags(){
//        return tags;
//    }
}
