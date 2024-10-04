package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow all paths
            .allowedOrigins("http://localhost:3004")  // Allow the React app origin
            .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow HTTP methods
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}
