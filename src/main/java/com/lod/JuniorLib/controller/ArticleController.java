package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/article/new")
    public String create(Model model) {
        model.addAttribute("appName", "Добавить статью");
        return "create";
    }

    @PostMapping("/article/new")
    public String doCreate(@ModelAttribute("title") String title, @ModelAttribute("content") String content
            , @ModelAttribute("subject") String subject,  @ModelAttribute("tags") String tags) {
        articleService.create(title, content, subject, tags);
        return "redirect:/articles";
    }

    @GetMapping("/article/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        articleService.remove(id);
        return "redirect:/articles";
    }
}
