package com.pendycorp.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Configuration
 * @author spendyala
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Set RequestHandlerSelectors, Path Selectors for Swagger UI and return Docket
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.pendycorp.todo.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.apiInfo(apiInfo());
	}

	/**
	 * Method to return API Info
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title("TODO List")
				.description("TODO List using Spring Boot")
				.version("1.0")
				.contact(new Contact("Srinath Pendyala", "", "sring.9@gmail.com"))
				.build();
	}
}
