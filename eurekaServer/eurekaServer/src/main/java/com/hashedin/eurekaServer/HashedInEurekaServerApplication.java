package com.hashedin.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HashedInEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HashedInEurekaServerApplication.class, args);
	}

}
