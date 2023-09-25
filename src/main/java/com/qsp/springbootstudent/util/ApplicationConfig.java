package com.qsp.springbootstudent.util;

import java.util.ArrayList;
import java.util.List;

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
@EnableSwagger2 //http://localhost:8080/swagger-ui.html#   link of swagger
public class ApplicationConfig {
	
	@Bean
	public Docket getDocket() {
		 Contact contact=new Contact("Jayesh Bari", "https://jayeshbari.com","bariajayesh155@gmail.com");
		 List<VendorExtension> list=new ArrayList<VendorExtension>();
		 ApiInfo apiInfo=new ApiInfo("STUDENT MANAGEMENT SYSTEM", "USE TO MANAGE DETAILS OF THE STUDENTS ", "Version 1.2", "1 year of Service", contact, "www.Sms.com","www.Sms.com", list);
		
		 return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.
				 basePackage("com.qsp.springbootstudent")).build().
				 apiInfo(apiInfo).useDefaultResponseMessages(false);
	}

}

