package dev.anhTuan.springsecurityBasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.anhTuan.springsecurityBasic.controller")
public class SpringsecurityBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityBasicApplication.class, args);
	}

}
