package com.lod.JuniorLib.controller;

import com.lod.JuniorLib.model.Role;
import com.lod.JuniorLib.model.User;
import com.lod.JuniorLib.repository.UserRepository;
import com.lod.JuniorLib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
//        if(!registrationService.addUser(user)) {
//            model.put("message", "User exists");
//            return "registration";
//        }
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
//        return "redirect:/login";
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb != null){
//            model.put("message", "User exists");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
