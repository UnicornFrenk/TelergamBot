package com.github.forResliv.entities;

import com.github.forResliv.model.City;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "city")
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class CityEntity {
    private Long id;
    private String cityName;
    private String cityDescription;


    public CityEntity(City city) {
        this.id = city.getId();
        this.cityName = city.getCityName();
        this.cityDescription = city.getCityDescription();
    }

    public CityEntity() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", unique = true)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Column(name = "description")

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    public City convertCityEntityToCity() {
        return new City(this.id, this.cityName, this.cityDescription);

    }

}

