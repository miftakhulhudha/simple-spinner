package com.example.miftakhulhudhadev.samplespinner.entity;

/**
 * Created by miftakhulhudhadev on 19/11/16.
 */

public class Street {

    private String name;
    private City city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name;
    }
}
