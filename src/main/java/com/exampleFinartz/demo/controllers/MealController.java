package com.exampleFinartz.demo.controllers;


import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.request.create.MealCreateRequest;
import com.exampleFinartz.demo.services.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("meal")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("{id}")
    public ResponseEntity<MealDTO> getMeal(@PathVariable Long id) {
        return new ResponseEntity(mealService.getMeal(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MealDTO> createMeal(@RequestBody MealCreateRequest mealCreateRequest) {
        return new ResponseEntity(mealService.createMeal(mealCreateRequest), HttpStatus.CREATED);
    }

}