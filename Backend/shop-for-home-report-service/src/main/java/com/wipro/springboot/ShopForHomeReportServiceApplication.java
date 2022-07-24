package com.wipro.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShopForHomeReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopForHomeReportServiceApplication.class, args);
	}

}
