package com.org.AddressbookSpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AddressbookSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressbookSpringAppApplication.class, args);
		System.out.println("Welcome To Addressbook App.");
	}
}
