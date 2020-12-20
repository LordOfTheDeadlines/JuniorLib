package com.lod.JuniorLib.model;

//import org.hibernate.validator.constraints.NotEmpty;

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

    @OneToMany(mappedBy = "subject", cascade=CascadeType.ALL, orphanRemoval = true)
    private Set<Article> articles;
}
