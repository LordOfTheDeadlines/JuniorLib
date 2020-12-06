package com.lod.JuniorLib.model;

//import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name= "subjects")
public class Subject {
    @Id
    @GeneratedValue
//    @Column(name = "sub_id")
    private Long id;

//    @Column(name = "sub_name", unique=true, nullable=false)
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

}
