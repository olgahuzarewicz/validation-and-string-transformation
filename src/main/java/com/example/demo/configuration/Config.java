package com.example.demo.configuration;

import com.example.demo.service.TransformationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TransformationService transformationService(){
        return new TransformationService();
    }
}
