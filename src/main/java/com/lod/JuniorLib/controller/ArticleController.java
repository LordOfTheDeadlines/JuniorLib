package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.model.Article;
import com.lod.JuniorLib.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/article/new")
    public String create(Model model) {
        model.addAttribute("appName", "Список статей");
        return "create";
    }

    @PostMapping("/article/new")
    public String doCreate(@ModelAttribute("title") String title, @ModelAttribute("content") String content
            , @ModelAttribute("subject") String subject) {
        articleService.create(title, content, subject);
        return "redirect:/";
    }


    @DeleteMapping("/article/{id}/delete")
    public void delete(@PathVariable("id") Long id){
        articleService.remove(id);
    }

}
