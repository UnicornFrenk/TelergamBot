package com.github.forResliv.configuration;

import com.github.forResliv.controller.CityRestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {

    private ServiceConfiguration serviceConfig;

    public RestConfiguration(ServiceConfiguration serviceConfig) {
        this.serviceConfig = serviceConfig;
    }


    @Bean
    public CityRestController getCityRestController() {
        return new CityRestController(serviceConfig.getCityService());
    }


}
