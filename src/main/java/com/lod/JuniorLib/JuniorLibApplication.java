package com.lod.JuniorLib;

import com.lod.JuniorLib.controller.*;
import com.lod.JuniorLib.service.ArticleService;
import com.lod.JuniorLib.service.SubjectService;
import com.lod.JuniorLib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.lod.JuniorLib.repository"})
public class JuniorLibApplication<SubscriberController> implements CommandLineRunner {

	@Autowired
	ArticleService articleService;

	@Autowired
	SubjectService subjectService;

	@Autowired
	UserService userService;

	@Autowired
	ArticleController articleController;

	@Autowired
	ArticleViewController articleViewController;

	@Autowired
	RegistrationController registrationController;

	@Autowired
	SubjectController subjectController;

	@Autowired
	SubjectViewController subjectViewController;

	public static void main(String[] args) {
		SpringApplication.run(JuniorLibApplication.class, args);
	}

	@Override
	public void run(String... args){
	}

}
