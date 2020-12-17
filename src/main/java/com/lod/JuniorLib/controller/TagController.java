package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public String tagsList(Model model) {
        model.addAttribute("appName", "Список тегов");
        model.addAttribute("tags", tagService.listAllTags());
        return "tagsList";
    }
}
