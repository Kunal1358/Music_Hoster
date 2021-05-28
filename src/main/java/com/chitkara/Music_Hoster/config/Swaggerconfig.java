package com.chitkara.Music_Hoster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2

public class Swaggerconfig {
    @Bean
    public Docket myapi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select().build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("MusicHoster API")
                .description("MusicHoster API for developers").termsOfServiceUrl("https://simplifyingtech371899608.wordpress.com/").licenseUrl("t92194@gmail.com").version("2.0").build();
    }
}
