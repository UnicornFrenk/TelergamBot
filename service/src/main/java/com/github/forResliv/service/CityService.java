package com.github.forResliv.service;

import com.github.forResliv.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    City addNewCity(City city);

    City updateCity(City city);

    void deleteCity(Long id);

    void deleteAll();

    List<City> addCities(List<City> list);

    List<City> getCitiesList();

    City getCityByName(String nameCity);

    City getCityById(Long id);


}
