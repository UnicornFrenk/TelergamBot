package com.github.forResliv;


import com.github.forResliv.model.City;

import java.util.List;


public interface CityDao {
    City addCity(City city);

    List<City> addCities(List<City> list);

    void updateCity(City city);

    void deleteCity(Long id);

    void deleteAll();

    List<City> getCitiesList();

    City getCityByName(String cityName);

    City getCityById(Long id);

}
