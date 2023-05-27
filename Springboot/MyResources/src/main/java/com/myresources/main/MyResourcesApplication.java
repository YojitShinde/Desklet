package com.myresources.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyResourcesApplication.class, args);
		System.out.println("Working!");
	}

}
