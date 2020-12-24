package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.model.User;
import com.lod.JuniorLib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());
        if(userFromDb != null){
            model.put("message", "User exists");
            return "registration";
        }
        userService.signUp(user);
        return "redirect:/login";
    }
}
