package com.example.contact_generator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI contactGeneratorOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Employee Contact QR Generator API")
                                .version("1.0")
                                .description(
                                        "API for retrieving employee information and generating contact QR codes."
                                )
                );
    }
}
