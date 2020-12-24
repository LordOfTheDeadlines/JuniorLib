package com.lod.JuniorLib;

import com.lod.JuniorLib.controller.ArticleController;
import com.lod.JuniorLib.controller.ArticleViewController;
import com.lod.JuniorLib.controller.RegistrationController;
import com.lod.JuniorLib.controller.SubjectController;
import com.lod.JuniorLib.service.ArticleService;
import com.lod.JuniorLib.service.SubjectService;
import com.lod.JuniorLib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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

	public static void main(String[] args) {
		SpringApplication.run(JuniorLibApplication.class, args);
	}

	@Override
	public void run(String... args){
	}

}
