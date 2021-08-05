package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entity.Restaurants;
import com.exampleFinartz.demo.enums.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantsService {

    public Restaurants create(Restaurants restaurants);

    public List<Restaurants> getAll();

    public Restaurants getById(Long id);

    public List<Restaurants> getByStatus(Position position);

    public Restaurants update(Restaurants restaurants);

    public Restaurants deleteById(Long id);

    String delete(Long id);
}