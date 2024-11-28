package com.example.back.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permettre CORS sur toutes les URL
                .allowedOrigins("http://localhost:4200") // Remplacez par l'origine autorisée
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes autorisées
                .allowedHeaders("*") 
                .allowCredentials(false); // Autoriser tous les en-têtes
              //.allowCredentials(true); // Autoriser les cookies ou l'authentification
    }
}


