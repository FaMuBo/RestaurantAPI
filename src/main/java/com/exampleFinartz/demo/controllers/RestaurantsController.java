package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.entity.Restaurants;
import com.exampleFinartz.demo.services.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {

    @Autowired
    private RestaurantsService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurants> create(@RequestBody Restaurants restaurants) {
        return new ResponseEntity<Restaurants>(restaurantService.create(restaurants), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Restaurants> update(@RequestBody Restaurants restaurants) {
        return new ResponseEntity<Restaurants>(restaurantService.update(restaurants), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Restaurants> get(@PathVariable Long id) {
        return new ResponseEntity<Restaurants>(restaurantService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Restaurants>> getAll() {
        return new ResponseEntity(restaurantService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        restaurantService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
