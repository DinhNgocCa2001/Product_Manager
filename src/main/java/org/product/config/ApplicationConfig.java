package org.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import static org.product.common.PathShop.SHOPEE;

@Configuration
public class ApplicationConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.create(SHOPEE);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
