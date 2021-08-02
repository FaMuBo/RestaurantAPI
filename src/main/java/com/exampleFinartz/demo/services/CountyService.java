package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.County;
import com.exampleFinartz.demo.repositories.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    @Autowired
    private CountyRepository countyRepository;

    public County create(County county) {
        County save = countyRepository.save(county);
        return save;
    }

    public List<County> getAll() {
        List<County> counties = countyRepository.findAll();
        return counties;
    }

    public County getById(Long id) {
        County county = countyRepository.getById(id);
        return county;
    }

    public County update(County county) {
        County foundCity = countyRepository.getById(county.getId());
        if (county.getName() != null) {
            foundCity.setName(county.getName());
        }
        return countyRepository.save(county);
    }

    public County deleteById(Long id) {
        County county = countyRepository.getById(id);
        if (county != null) {
            countyRepository.deleteById(id);
            return county;
        }
        return county;
    }

    public String delete(long id) {
        countyRepository.deleteById(id);
        return "SUCCESS";
    }
}
