package com.connex.vehicle.Angularspringbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AngularSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularSpringbootApplication.class, args);
		System.out.println("Welcome to the Vehicle Management System");
	}

}
