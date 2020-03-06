package com.github.forResliv.repository;

import com.github.forResliv.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityJpaRepository extends JpaRepository<CityEntity, Long> {
    CityEntity getCityEntityByCityName(String cityName);
}
