package com.lod.JuniorLib;

import com.lod.JuniorLib.controller.ArticleController;
import com.lod.JuniorLib.controller.ArticleViewController;
import com.lod.JuniorLib.controller.RegistrationController;
import com.lod.JuniorLib.controller.SubjectController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JuniorLibApplication<SubscriberController> implements CommandLineRunner {



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
