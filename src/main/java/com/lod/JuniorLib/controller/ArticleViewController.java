package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.model.Article;
import com.lod.JuniorLib.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

@Controller
public class ArticleViewController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/articles")
    public String list(Model model) {
        model.addAttribute("appName", "Список статей");
        model.addAttribute("articles", articleService.listAllArticles());
        return "list";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable("id") Long id, Model model) {
        model.addAttribute("article",articleService.find(id));
        return "article";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Article>articles;
        if(filter != null && !filter.isEmpty())
            articles = articleService.findBySubject(filter);
        else  articles = articleService.listAllArticles();
        model.put("appName", "Список статей по предмету "+filter);
        model.put("articles", articles);
        return "list";
    }
    @PostMapping("filterByTags")
    public String filterByTags(@RequestParam String filterByTags, Map<String, Object> model){
        Iterable<Article>articles;
        if(filterByTags != null && !filterByTags.isEmpty())
            articles = articleService
                    .findByTagsList(Arrays.asList(filterByTags.split(" ")));
        else  articles = articleService.listAllArticles();
        model.put("appName", "Поиск по "+filterByTags);
        model.put("articles", articles);
        return "list";
    }

}
