package com.org.AddressbookSpringApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.modelmapper.ModelMapper;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class AddressbookSpringAppApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(AddressbookSpringAppApplication.class, args);
		log.info("Welcome To Addressbook App");
	}
}