package com.ust.UstServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UstServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UstServerApplication.class, args);
	}

}
