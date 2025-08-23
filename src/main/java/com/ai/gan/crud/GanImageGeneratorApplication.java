package com.ai.gan.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:8080/h2-console

@SpringBootApplication
public class GanImageGeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(GanImageGeneratorApplication.class, args);
	}
}