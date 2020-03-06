package com.github.forResliv.service;

import com.github.forResliv.CityDao;
import com.github.forResliv.model.City;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CityServiceImpl implements CityService {


    private CityDao cityDAO;

    public CityServiceImpl(CityDao cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public City addNewCity(City city) {
        return cityDAO.addCity(city);
    }

    @Override
    public City updateCity(City city) {
        cityDAO.updateCity(city);
        return cityDAO.getCityById(city.getId());
    }

    @Override
    public void deleteCity(Long id) {
        cityDAO.deleteCity(id);
    }

    @Override
    public void deleteAll() {
        cityDAO.deleteAll();
    }

    @Override
    public List<City> addCities(List<City> list) {
        return cityDAO.addCities(list);
    }

    @Override
    public List<City> getCitiesList() {
        return cityDAO.getCitiesList();
    }

    @Override
    public City getCityByName(String nameCity) {
        return cityDAO.getCityByName(nameCity);
    }

    @Override
    public City getCityById(Long id) {
        return cityDAO.getCityById(id);
    }
}
