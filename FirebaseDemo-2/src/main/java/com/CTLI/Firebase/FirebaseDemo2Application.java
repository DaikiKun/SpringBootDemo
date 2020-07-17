package com.CTLI.Firebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.Firebase")
public class FirebaseDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(FirebaseDemo2Application.class, args);
	}

}
