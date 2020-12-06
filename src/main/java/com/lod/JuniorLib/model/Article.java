package com.lod.JuniorLib.model;

import com.sun.istack.NotNull;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
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



////    @Column(name = "subject", nullable=false)
//    @ManyToOne (optional=false, cascade=CascadeType.ALL)
////    @JoinColumn(name="sub_id", nullable=false)
//        @JoinTable(name = "subjects",
//            joinColumns = { @JoinColumn(name = "id") },
//            inverseJoinColumns = { @JoinColumn(name = "sub_id") })
    private String subject;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "tags",
//            joinColumns = { @JoinColumn(name = "id") },
//            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
//    private Set<Tag> tags = new HashSet<>();

    public Article(){

    }

    public Article(String title, String content, String subject){//, Set<Tag> tags){
        this.title = title;
        this.content = content;
        this.subject = subject;
//        this.tags = tags;
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

    public String getSubject(){
        return subject;
    }

//    public Set<Tag> getTags(){
//        return tags;
//    }
}
