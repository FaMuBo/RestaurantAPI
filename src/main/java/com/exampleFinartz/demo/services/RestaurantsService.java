package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Restaurants;
import com.exampleFinartz.demo.enums.Position;
import com.exampleFinartz.demo.repositories.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantsService {
    @Autowired
    private RestaurantsRepository restaurantRepository;

    public Restaurants create(Restaurants restaurants) {
        Restaurants save = restaurantRepository.save(restaurants);
        return save;
    }

    public List<Restaurants> getAll() {
        List<Restaurants> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public Restaurants getById(Long id) {
        Restaurants restaurants = restaurantRepository.getById(id);
        return restaurants;
    }

    public List<Restaurants> getByStatus(Position position) {
        List<Restaurants> restaurants = restaurantRepository.findAllByPosition(Position.WAITING);
        return restaurants;
    }

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

    public Restaurants deleteById(Long id) {
        Restaurants restaurants = restaurantRepository.getById(id);
        if (restaurants != null) {
            restaurantRepository.deleteById(id);
            return restaurants;
        }
        return restaurants;
    }

    public String delete(long id) {
        restaurantRepository.deleteById(id);
        return "SUCCESS";
    }
}
