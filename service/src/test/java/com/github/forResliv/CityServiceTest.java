package com.github.forResliv;

import com.github.forResliv.model.City;
import com.github.forResliv.service.CityServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {
    City city;
    @Mock
    CityDao dao;
    @InjectMocks
    CityServiceImpl defaultCityService;

    @Test
    void addCity() {
        when(dao.addCity(city)).thenReturn(city);
        city = defaultCityService.addNewCity(city);
        assertNotNull(city);
        assertEquals(city.getCityName(), "Москва");
    }

    @Test
    void updateCity() {
        when(dao.getCityById(city.getId())).thenReturn(city);
        city = defaultCityService.updateCity(city);
        verify(dao, times(1)).updateCity(city);
        assertNotNull(city);
    }

    @Test
    void deleteCity() {
        defaultCityService.deleteCity(1l);
        verify(dao, times(1)).deleteCity(1l);
    }

    @Test
    void deleteCityAll() {
        defaultCityService.deleteAll();
        verify(dao, times(1)).deleteAll();
    }

    @Test
    void getListCity() {
        when(dao.getCitiesList()).thenReturn(new ArrayList<City>());
        assertNotNull(defaultCityService.getCitiesList());
    }

    @Test
    void getCityByName() {
        when(defaultCityService.getCityByName(city.getCityName())).thenReturn(city);
        assertNotNull(defaultCityService.getCityByName(city.getCityName()));
    }

    @Test
    void getCityById() {
        when(defaultCityService.getCityById(city.getId())).thenReturn(city);
        assertNotNull(defaultCityService.getCityById(city.getId()));

    }

    @Test
    void testAddCity() {

        when(defaultCityService.addCities(new ArrayList<>())).thenReturn(new ArrayList<>());
        assertNotNull(defaultCityService.addCities(new ArrayList<>()));
    }

    @BeforeEach
    void setUp() {
        city = new City(1l, "Москва", "Там много народу");
    }

}