package com.raw1.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raw1.app.Repo.ProductRepo;

@SpringBootApplication
public class Raw1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Raw1Application.class, args);
		
	}
	

}
