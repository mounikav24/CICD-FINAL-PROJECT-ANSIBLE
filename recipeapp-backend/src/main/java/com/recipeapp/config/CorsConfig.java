package com.recipeapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowedOrigins(
                                // Local development
                                "http://localhost:5173",
                                "http://127.0.0.1:5173",
                                "http://localhost",
                                "http://127.0.0.1",

                                // Vite / local frontend
                                "http://localhost:30019",
                                "http://127.0.0.1:30019",

                                // Kubernetes NodePort frontend
                                "http://192.168.1.10:30019",

                                // Docker internal
                                "http://react",
                                "http://react:80"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
