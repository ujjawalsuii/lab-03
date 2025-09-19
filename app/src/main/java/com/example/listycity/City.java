package com.example.listycity;

public class City {
    private String cityName;
    private String provinceName;

    public City(String cityName, String provinceName) {
        this.cityName = cityName;
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return cityName + ", " + provinceName;
    }
}
