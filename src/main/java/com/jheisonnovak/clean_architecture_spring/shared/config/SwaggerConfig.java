package com.jheisonnovak.clean_architecture_spring.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI openAPI() {
        String projectVersion = getClass().getPackage().getImplementationVersion();
        return new OpenAPI()
            .info(new io.swagger.v3.oas.models.info.Info()
                .title("Clean Architecture API")
                .version(projectVersion != null ? projectVersion : "1.0.0")
                .description("API documentation for Clean Architecture Spring project"));
    }

}
