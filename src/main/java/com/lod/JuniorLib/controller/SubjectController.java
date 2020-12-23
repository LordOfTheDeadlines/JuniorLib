package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @DeleteMapping("/subject/{id}/delete")
    public void delete(@PathVariable("id") Long id){
        subjectService.remove(id);
    }
}
