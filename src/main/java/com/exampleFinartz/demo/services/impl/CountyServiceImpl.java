package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entities.County;
import com.exampleFinartz.demo.repositories.CountyRepository;
import com.exampleFinartz.demo.services.CountyService;

import java.util.List;

public class CountyServiceImpl implements CountyService {

    private CountyRepository countyRepository;

    public CountyServiceImpl(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    @Override
    public County create(County county) {
        County save = countyRepository.save(county);
        return save;
    }

    @Override
    public List<County> getAll() {
        List<County> counties = countyRepository.findAll();
        return counties;
    }

    @Override
    public County getById(Long id) {
        County county = countyRepository.getById(id);
        return county;
    }

    @Override
    public County update(County county) {
        County foundCity = countyRepository.getById(county.getId());
        if (county.getName() != null) {
            foundCity.setName(county.getName());
        }
        return countyRepository.save(county);
    }

    @Override
    public County deleteById(Long id) {
        County county = countyRepository.getById(id);
        if (county != null) {
            countyRepository.deleteById(id);
            return county;
        }
        return county;
    }

    @Override
    public String delete(Long id) {
        countyRepository.deleteById(id);
        return "SUCCESS";
    }
}
