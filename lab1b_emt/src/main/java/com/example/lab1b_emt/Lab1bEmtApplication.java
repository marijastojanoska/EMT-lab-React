package com.example.lab1b_emt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Lab1bEmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab1bEmtApplication.class, args);
	}

}
