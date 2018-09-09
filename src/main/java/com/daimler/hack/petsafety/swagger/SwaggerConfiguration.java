package com.daimler.hack.petsafety.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * URl http://localhost:8080/swagger-ui.html
 *
 *
 * @author SSREEKA
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    // ***************************************************************************************************************
    // ******************************************** Public Fields ****************************************************
    // ***************************************************************************************************************

    // ***************************************************************************************************************
    // ****************************************** Non Public Fields **************************************************
    // ***************************************************************************************************************

    // ***************************************************************************************************************
    // *********************************************** Constructors **************************************************
    // ***************************************************************************************************************

    // ***************************************************************************************************************
    // ******************************************** Public Methods ***************************************************
    // ***************************************************************************************************************

   /* @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/persafety-api/.*")).build().apiInfo(apiInfo())
                .tags(new Tag("Petsafety Endpoint", "Petsafety Swagger"));
    }*/
	
	@Bean
    public Docket productApi() {
        return new Docket( DocumentationType.SWAGGER_2 ).select().apis( RequestHandlerSelectors.basePackage( "com.daimler.hack.petsafety.endpoint" ) ).build()
                .apiInfo( apiInfo() );
    }
    // ***************************************************************************************************************
    // ****************************************** Non Public Methods *************************************************
    // ***************************************************************************************************************

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("petsafety").description("petsafety").version("v1")
                .contact(new Contact("Sadashiv", null, "sadashivamurthi.streekantappa@daimler.com")).build();
    }
}
