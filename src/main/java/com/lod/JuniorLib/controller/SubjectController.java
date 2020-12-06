package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SubjectController {

    @Autowired
    SubjectService subjectService;

//    @GetMapping("/article/new")
//    public String create(Model model) {
//        model.addAttribute("appName", "Список предметов");
//        return "create";
//    }


    @DeleteMapping("/subject/{id}/delete")
    public void delete(@PathVariable("id") Long id){
        //каскадное
        subjectService.remove(id);
    }
}
