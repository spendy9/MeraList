package com.pendycorp.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot
 * @author spendyala
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.pendycorp.todo")
public class MeraListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeraListApplication.class, args);
	}
}
