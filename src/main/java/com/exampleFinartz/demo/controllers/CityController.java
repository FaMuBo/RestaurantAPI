package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.entities.City;
import com.exampleFinartz.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")

public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city) {
        return new ResponseEntity<City>(cityService.create(city), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<City> update(@RequestBody City city) {
        return new ResponseEntity<City>(cityService.update(city), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<City> get(@PathVariable Long id) {
        return new ResponseEntity<City>(cityService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<City> deleteById(@PathVariable Long id) {
        cityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
