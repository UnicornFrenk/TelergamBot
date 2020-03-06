package com.github.forResliv.configuration;

import com.github.forResliv.service.CityService;
import com.github.forResliv.service.CityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    private DaoConfiguration daoConfig;


    public ServiceConfiguration(DaoConfiguration daoConfig) {
        this.daoConfig = daoConfig;
    }

    @Bean
    public CityService getCityService() {
        return new CityServiceImpl(daoConfig.getDefaultCityDAO());


    }
}