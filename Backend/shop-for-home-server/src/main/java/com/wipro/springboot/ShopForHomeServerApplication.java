package com.wipro.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShopForHomeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopForHomeServerApplication.class, args);
	}
}
