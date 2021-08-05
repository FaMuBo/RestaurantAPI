package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entity.City;
import com.exampleFinartz.demo.repositories.CityRepository;
import com.exampleFinartz.demo.services.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(City city) {
        City save = cityRepository.save(city);
        return save;
    }

    @Override
    public List<City> getAll() {
        List<City> cities = cityRepository.findAll();
        return cities;
    }

    @Override
    public City getById(Long id) {
        City city = cityRepository.getById(id);
        return city;
    }

    @Override
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

    @Override
    public City deleteById(Long id) {
        City city = cityRepository.getById(id);
        if (city != null) {
            cityRepository.deleteById(id);
            return city;
        }
        return city;
    }

    @Override
    public String delete(Long id) {
        cityRepository.deleteById(id);
        return "SUCCESS";
    }
}
