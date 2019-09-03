package com.coding.task.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.coding.task")).paths(regex("/api.*")).build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("Java Developer Coding Task",
				"<strong>Welcome to REST API - Banking Application</strong> <br> "
				+ "To get access to client methods, first you need to SignUp/LogIn.<br>"
				+ "You can do it through CLIENT CONTROLLER Post Methods or if you prefer, it's possible to do the same thing in our UI at <a href=\"/api\">API CONNECT</a>.<br>"
				+ "<br><B>» Methods - How to [POST] and [GET]</B><br>"
				+"<br>--------------<br>"
				+ " - Register a new client [POST] »» /api/signup<br>"
				+ "-posting-<br>"
				+ "{<br>"
				+ "&nbsp \"fullName\": \"string\",<br>"
				+ "&nbsp \"email\": \"string\",<br>"
				+ "&nbsp \"password\": \"string\"<br>"
				+ "}"
				+"<br>--------------<br>"
				+ " - Client initiate session [POST] »» /api/login<br>"
				+ "-posting-<br>"
				+ "{<br>"
				+ "&nbsp \"email\": \"string\",<br>"
				+ "&nbsp \"password\": \"string\"<br>"
				+ "}"
				+"<br>--------------<br>"
				+ " - Client ends session [POST] »» /api/logout"
				+"<br>--------------<br>"
				+ " - Return client's profile [GET] »» /api/myprofile"
				+"<br>--------------<br>"
				+ " - Return all clients in system [ONLY ALLOWED PASSING THE SECRET KEY AS PARAMETER] [GET] »» /api/client/all/{secretKey}"
				+"<br>secretKey by example on system = 3861</span>"
				+"<br>--------------<br>"
				+ " - Return all accounts in system [ONLY ALLOWED PASSING THE SECRET KEY AS PARAMETER] [GET] »» /api/account/all/{secretKey}"
				+"<br>secretKey by example on system = 3861</span>"
				+"<br>--------------<br>"
				+ " - Return client's account balance [GET] »» /api/account/myaccount"
				+"<br>--------------<br>"
				+ " - Register deposit transaction on client's account [POST] »» /api/account/myaccount/deposit<br>"
				+ "-posting-<br>"
				+ "{<br>"
				+ "&nbsp \"value\": \"0\",<br>"
				+ "}"
				+"<br>--------------<br>"
				+ " - Register withdrawal transaction on client's account [POST] »» /api/account/myaccount/withdrawal<br>"
				+ "-posting-<br>"
				+ "{<br>"
				+ "&nbsp \"value\": \"0\",<br>"
				+ "}"
				+"<br>--------------<br>"
				+ " - Return client account statment [GET] »» /api/account/myaccount/statement"
				+"<br>--------------<br>"
				+ "" ,
				"", "", new Contact("Pedro Azzam", "https://pedroazzam.me", "pedro@pedroazzam.me"), "", "",
				new ArrayList<VendorExtension>());

		return apiInfo;
	}

}
