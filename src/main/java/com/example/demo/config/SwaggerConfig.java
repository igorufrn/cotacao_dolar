package com.example.demo.config;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {   

    

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()

                .paths(Predicates.not(PathSelectors.regex("/error")))
                .paths(Predicates.not(PathSelectors.regex("/oauth/authorize")))
                .paths(Predicates.not(PathSelectors.regex("/oauth/check_token")))
                .paths(Predicates.not(PathSelectors.regex("/oauth/token")))
                .paths(Predicates.not(PathSelectors.regex("/oauth/token_key")))
                .paths(Predicates.not(PathSelectors.regex("/oauth/confirm_access")))
                .paths(Predicates.not(PathSelectors.regex("/oauth/error")))
                .paths(Predicates.not(PathSelectors.regex("/tokens/logout")))

                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build()
                .pathMapping("/")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("Igor Linnik Câmara Araújo", "https://www.linkedin.com/in/igor-linnik-8549462b/",
                "igor.ufrn@gmail.com");


        return new ApiInfo(
                "COTACAO DO DOLAR",
                "Serviço desenvolvido para auxiliar investidores na compra do dólar",
                "0.1",
                null,
                contact,
                null,
                null,
                new ArrayList<>());
    }


}