package com.manish.javadev.controller;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket restApiDocument() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.manish.javadev.controller")).paths(regex("/api.*"))
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		Contact contact = new Contact("M.D Srivastava", "http://manishjavadev.com/home.html",
				"m.d.srivastava@accenture.com");
		ApiInfo apiInfo = new ApiInfo("Enjoy Paperless, Branchless Banking Solution with digibank by DBS",
				"Paperless Bank API, for Online Bank", "1.0", "Terms of service", contact, "Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}
}