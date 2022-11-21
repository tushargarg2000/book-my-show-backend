package com.example.project.bookmyshowbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BookMyShowBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowBackendApplication.class, args);
	}

}
