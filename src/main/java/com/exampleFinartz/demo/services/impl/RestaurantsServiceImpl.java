package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entities.Restaurants;
import com.exampleFinartz.demo.enums.Position;
import com.exampleFinartz.demo.repositories.RestaurantsRepository;
import com.exampleFinartz.demo.services.RestaurantsService;

import java.util.List;

public class RestaurantsServiceImpl implements RestaurantsService {


    private RestaurantsRepository restaurantRepository;

    public RestaurantsServiceImpl(RestaurantsRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurants create(Restaurants restaurants) {
        Restaurants save = restaurantRepository.save(restaurants);
        return save;
    }

    @Override
    public List<Restaurants> getAll() {
        List<Restaurants> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    @Override
    public Restaurants getById(Long id) {
        Restaurants restaurants = restaurantRepository.getById(id);
        return restaurants;
    }

    public List<Restaurants> getByStatus(Position position) {
        List<Restaurants> restaurants = restaurantRepository.findAllByPosition(Position.WAITING);
        return restaurants;
    }

    @Override
    public Restaurants update(Restaurants restaurants) {
        Restaurants foundRestaurant = restaurantRepository.getById(restaurants.getId());
        if (restaurants.getName() != null) {
            foundRestaurant.setName(restaurants.getName());
        }
        if (restaurants.getBranch() != null) {
            foundRestaurant.setBranch(restaurants.getBranch());
        }
        if (restaurants.getUser() != null) {
            foundRestaurant.setUser(restaurants.getUser());
        }
        if (restaurants.getPosition() != null) {
            foundRestaurant.setPosition(restaurants.getPosition());
        }
        return restaurantRepository.save(restaurants);
    }

    @Override
    public Restaurants deleteById(Long id) {
        Restaurants restaurants = restaurantRepository.getById(id);
        if (restaurants != null) {
            restaurantRepository.deleteById(id);
            return restaurants;
        }
        return restaurants;
    }

    @Override
    public String delete(Long id) {
        restaurantRepository.deleteById(id);
        return "SUCCESS";
    }
}
