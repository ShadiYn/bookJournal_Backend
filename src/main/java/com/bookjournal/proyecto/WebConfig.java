package com.bookjournal.proyecto;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:5173")
                .allowedOrigins("http://localhost:5173") // Your React app's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                .allowCredentials(true); // Allow credentials if needed
    }
}
