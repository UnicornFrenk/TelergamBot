package com.github.forResliv.configuration;

import com.github.forResliv.CityDao;
import com.github.forResliv.CityDaoImpl;
import com.github.forResliv.repository.CityJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.github.forResliv.repository"})
@EntityScan("com.github.forResliv.entities")
public class DaoConfiguration {
    @Autowired
    private CityJpaRepository cityJpaRepository;

    @Bean
    public CityDao getDefaultCityDAO() {
        return new CityDaoImpl(cityJpaRepository);

    }


}
