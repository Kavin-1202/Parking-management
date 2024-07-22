package com.ust.cloud_config_parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigParkingApplication.class, args);
	}

}
