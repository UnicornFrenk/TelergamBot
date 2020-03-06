package com.github.forResliv;

import com.github.forResliv.model.City;
import com.github.forResliv.configuration.DaoConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes = DaoConfiguration.class)
@Transactional
class CityDaoTest {
    @Autowired
    CityDao dao;

    @Test
    void addCity() {
        City city = dao.addCity(new City(null, "Париж", "Город любви!"));
        City city2 = dao.addCity(new City(null, "Москва", "Пробки"));
        assertNotNull(city);
        assertNotNull(city2);
    }

    @Test
    void updateCity() {
        City city = dao.getCityByName("Москва");
        city.setCityDescription("Пробки");
        dao.updateCity(city);
        city = dao.getCityById(city.getId());
        assertEquals("Пробки", city.getCityDescription());
    }

    @Test
    void deleteCity() {
        City city = dao.getCityByName("Москва");
        assertNotNull(city);
        dao.deleteCity(city.getId());
        city = dao.getCityByName("Москва");
        assertNull(city);
    }

    @Test
    void deleteCityAll() {
        assertFalse(dao.getCitiesList().isEmpty());
        dao.deleteAll();
        assertTrue(dao.getCitiesList().isEmpty());
    }

    @Test
    void getListCity() {
        List<City> cityList = dao.getCitiesList();
        assertFalse(cityList.isEmpty());
        assertEquals(6, cityList.size());
    }


    @Test
    void getCityByName() {
        assertNotNull(dao.getCityByName("Лондон"));
        assertNotNull(dao.getCityByName("Париж"));
        assertNull(dao.getCityByName("Берлин"));
    }

    @Test
    void getCityById() {
        assertNotNull(dao.getCityByName("Лондон"));
        assertNotNull(dao.getCityByName("Пекин"));
        assertNull(dao.getCityById(33L));
    }


    @Test
    void addListCity() {
        City city = new City(null, "Берлин", "Берлинская стена");
        City city2 = new City(null, "Венеция", "На воде");
        List<City> list = new ArrayList<>();
        list.add(city);
        list.add(city2);
        assertFalse((dao.addCities(list)).isEmpty());
        dao.deleteAll();
        assertTrue((dao.addCities(new ArrayList<>())).isEmpty());
    }

    @BeforeEach
    void setUp() {
        dao.addCity(new City(null, "Москва", "Красная площадь"));
        dao.addCity(new City(null, "Париж", "Эйфелева башня"));
        dao.addCity(new City(null, "Пекин", "Дешевая одежда!"));
        dao.addCity(new City(null, "Лондон", "Королева"));
        dao.addCity(new City(null, "Нью-Йорк", "Статуя Свободы!"));
        dao.addCity(new City(null, "Нью-Джерси", "Пляжи"));

    }


}