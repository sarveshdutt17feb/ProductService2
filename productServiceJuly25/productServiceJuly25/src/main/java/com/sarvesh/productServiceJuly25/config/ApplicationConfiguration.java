package com.sarvesh.productServiceJuly25.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ApplicationConfiguration {
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
