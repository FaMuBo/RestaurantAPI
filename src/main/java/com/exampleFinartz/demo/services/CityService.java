package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entity.City;

import java.util.List;

public interface CityService {

    public City create(City city);

    public List<City> getAll();

    public City getById(Long id);

    public City update(City city);

    public City deleteById(Long id);

    String delete(Long id);
}