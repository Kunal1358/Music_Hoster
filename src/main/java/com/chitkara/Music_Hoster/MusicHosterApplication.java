package com.chitkara.Music_Hoster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MusicHosterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicHosterApplication.class, args);
	}



	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()).select().build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Music API")
				.description("Music API for developers").termsOfServiceUrl("https://simplifyingtech371899608.wordpress.com/").licenseUrl("t9814312194@gmail.com").version("2.0").build();
	}
}
