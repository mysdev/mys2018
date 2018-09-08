package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {

	public static void main(String[] args) {
//		SpringApplication springApplication = new SpringApplication(Application .class);
//		springApplication.addListeners(new ApplicationStartup());
		SpringApplication.run(Application.class, args);
	}
}
