package com.example.s3test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("test open api document")
                .version("v0.0.1")
                .description("test 를 위한 api 명세서");
        return new OpenAPI()
                .info(info);
    }
}
