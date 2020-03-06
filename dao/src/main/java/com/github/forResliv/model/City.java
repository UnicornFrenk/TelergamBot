package com.github.forResliv.model;

public class City {
    private Long id;
    private String cityName;
    private String cityDescription;

    public City(Long id, String cityName, String cityDescription) {
        this.id = id;
        this.cityName = cityName;
        this.cityDescription = cityDescription;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }
}
