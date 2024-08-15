package com.hashedin.jobService;

//import com.hashedin.jobService.exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableSwagger2
//@RestControllerAdvice
public class HashedInJobPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HashedInJobPortalApplication.class, args);
	}

//	@Bean
//	public GlobalExceptionHandler globalExceptionHandler() {
//		return new GlobalExceptionHandler();
//	}
}
