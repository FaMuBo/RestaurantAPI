package com.exampleFinartz.demo.controllers;


import com.exampleFinartz.demo.entities.Meal;
import com.exampleFinartz.demo.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealService mealService;

    @PostMapping
    public ResponseEntity<Meal> create(@RequestBody Meal meal) {
        return new ResponseEntity<Meal>(mealService.create(meal), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Meal> update(@RequestBody Meal meal) {

        return new ResponseEntity<Meal>(mealService.update(meal), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> get(@PathVariable Long id) {
        return new ResponseEntity<Meal>(mealService.getById(id), HttpStatus.OK);
    }

    //neden responseentitiy<?> ? yi siliyoruz (Meal)
    @GetMapping
    public ResponseEntity<List<Meal>> getAll() {
        return new ResponseEntity<>(mealService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        mealService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
