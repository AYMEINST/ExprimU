package org.exprimu.prog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:application.properties")
public class ExprimUApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExprimUApplication.class, args);
	}
}
