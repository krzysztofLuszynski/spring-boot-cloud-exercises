package kluszynski.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    @Autowired
    private RestTemplateResponseErrorHandler restTemplateResponseErrorHandler;

    @Bean(name="cleanRestTemplate")
    public RestTemplate getRestTemplate(final RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.errorHandler(
                restTemplateResponseErrorHandler).build();
    }

    @LoadBalanced
    @Bean(name="loadBalancedRestTemplate")
    public RestTemplate getRestTemplateLoadBalancer(final RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.errorHandler(
                restTemplateResponseErrorHandler).build();
    }
}
