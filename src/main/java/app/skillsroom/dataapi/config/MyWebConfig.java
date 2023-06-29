package app.skillsroom.dataapi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//If I want to define a bean, I need to create a configuration class
@Configuration
public class MyWebConfig {
    //Rest Template is used for API communication ? 
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
