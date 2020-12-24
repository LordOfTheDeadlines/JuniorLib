package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/subjects")
    public String subjectList(Model model) {
        model.addAttribute("appName", "Список предметов");
        model.addAttribute("subjects", subjectService.listAllSubjects());
        return "subjectList";
    }

    @ResponseBody
    @GetMapping("/subject/{id}")
    public String subjectArticles(@PathVariable("id") Long id, Model model) {
        String name = subjectService.find(id).getName();
        model.addAttribute("appName", "Список статей по предмету "+name);
        return "subjectArticles";
    }
}
