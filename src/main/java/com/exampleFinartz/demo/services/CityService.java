package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.City;
import com.exampleFinartz.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City create(City city) {
        City save = cityRepository.save(city);
        return save;
    }

    public List<City> getAll() {
        List<City> cities = cityRepository.findAll();
        return cities;
    }

    public City getById(Long id) {
        City city = cityRepository.getById(id);
        return city;
    }

    public City update(City city) {
        City foundCity = cityRepository.getById(city.getId());
        if (city.getCounty() != null) {
            foundCity.setCounty(city.getCounty());
        }
        if (city.getName() != null) {
            foundCity.setName(city.getName());
        }
        return cityRepository.save(city);
    }

    public City deleteById(Long id) {
        City city = cityRepository.getById(id);
        if (city != null) {
            cityRepository.deleteById(id);
            return city;
        }
        return city;
    }

    public String delete(long id) {
        cityRepository.deleteById(id);
        return "SUCCESS";
    }

}
