package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.model.Article;
import com.lod.JuniorLib.service.ArticleService;
import com.lod.JuniorLib.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ArticleViewController {

    @Autowired
    ArticleService articleService;

    @Autowired
    TagService tagService;

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/articles")
    public String list(Model model) {
        model.addAttribute("appName", "Список статей");
        model.addAttribute("articles", articleService.listAllArticles());
        model.addAttribute("tags", tagService.listAllTags());
        return "list";
    }

    @ResponseBody
    @GetMapping("/article/{id}")
    public String article(@PathVariable("id") Long id, Model model) {
        model.addAttribute("title", articleService.find(id).getTitle());
        model.addAttribute("content", articleService.find(id).getContent());
        return articleService.find(id).getContent();
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Article>articles;
        if(filter != null && !filter.isEmpty())
            articles = articleService.findBySubject(filter);
        else  articles = articleService.listAllArticles();
        model.put("articles", articles);
        return "list";
    }
    @PostMapping("filterByTags")
    public String filterByTags(@RequestParam String filterByTags, Map<String, Object> model){
        Iterable<Article>articles;
        if(filterByTags != null && !filterByTags.isEmpty())
            articles = articleService.findByTagsList(null);
        else  articles = articleService.listAllArticles();
        model.put("articles", articles);
        return "list";
    }

}
