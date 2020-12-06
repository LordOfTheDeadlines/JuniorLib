package com.lod.JuniorLib.service;

import com.lod.JuniorLib.model.User;
import com.lod.JuniorLib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    UserRepository userRepository;

    public RegistrationService(){

    }

    public Boolean addUser(User user){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb != null){
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
