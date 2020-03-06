package com.github.forResliv;

import com.github.forResliv.model.City;
import com.github.forResliv.entities.CityEntity;
import com.github.forResliv.repository.CityJpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CityDaoImpl implements CityDao {
    private CityJpaRepository cityJpaRepository;

    public CityDaoImpl(CityJpaRepository cityJpaRepository) {
        this.cityJpaRepository = cityJpaRepository;
    }

    //save or update
    @Override
    public City addCity(City city) {
        CityEntity cityEntity =
                cityJpaRepository.getCityEntityByCityName(city.getCityName());
        if (cityEntity != null) {
            city.setId(cityEntity.getId());
        }
        return cityJpaRepository.save(new CityEntity(city)).convertCityEntityToCity();
    }

    @Override
    public List<City> addCities(List<City> list) {
        return list.isEmpty()
                ? new ArrayList<>()
                : cityJpaRepository.saveAll(list.stream().map(CityEntity::new).collect(Collectors.toList()))
                .stream().map(CityEntity::convertCityEntityToCity).collect(Collectors.toList());
    }

    @Override
    public void updateCity(City city) {
        addCity(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityJpaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cityJpaRepository.deleteAll();
    }


    @Override
    public List<City> getCitiesList() {
        List<CityEntity> cityEntityList = cityJpaRepository.findAll();
        return cityEntityList.stream().map(
                cityEntity -> cityEntity.convertCityEntityToCity()).collect(Collectors.toList());
    }

    @Override
    public City getCityByName(String nameCity) {
        CityEntity cityEntity = cityJpaRepository.getCityEntityByCityName(nameCity);
        return cityEntity == null ? null : cityEntity.convertCityEntityToCity();
    }

    @Override
    public City getCityById(Long id) {
        Optional<CityEntity> optional = cityJpaRepository.findById(id);
        return optional.map(cityEntity -> cityEntity.convertCityEntityToCity()).orElse(null);
    }
}
