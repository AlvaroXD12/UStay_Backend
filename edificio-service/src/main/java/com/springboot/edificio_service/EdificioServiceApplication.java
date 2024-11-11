package com.springboot.edificio_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.edificio_service"})
@EnableEurekaServer
public class EdificioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdificioServiceApplication.class, args);
	}

}
