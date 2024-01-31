package com.Security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.Security.demo")
@ComponentScan(basePackages = "com.example")
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        // Retrieve the UserService bean from the Spring context
        UserService userService = context.getBean(UserService.class);

        // Use the userService to create a user
        userService.createUser("vijay", "12345");


   
   

	}

}
