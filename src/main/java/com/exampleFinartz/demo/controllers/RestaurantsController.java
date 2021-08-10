package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.enums.Position;
import com.exampleFinartz.demo.models.request.create.RestaurantsCreateRequest;
import com.exampleFinartz.demo.models.request.update.RestaurantsUpdateRequest;
import com.exampleFinartz.demo.services.RestaurantsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurant")
public class RestaurantsController {

    private final RestaurantsService restaurantsService;

    public RestaurantsController(RestaurantsService restaurantsService) {
        this.restaurantsService = restaurantsService;
    }

    @GetMapping("waiting")
    public ResponseEntity<List<RestaurantsDTO>> getRestaurants(Position position) {
        return new ResponseEntity(restaurantsService.getRestaurants(position.WAITING), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RestaurantsDTO> getRestaurant(@PathVariable Long id) {
        return new ResponseEntity(restaurantsService.getRestaurant(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantsDTO> createRestaurants(@RequestBody RestaurantsCreateRequest restaurantsCreateRequest) {
        return new ResponseEntity(restaurantsService.createRestaurants(restaurantsCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<RestaurantsDTO> updateRestaurants(@PathVariable Long id, @RequestBody RestaurantsUpdateRequest restaurantsUpdateRequest) {
        return new ResponseEntity(restaurantsService.updateRestaurants(id, restaurantsUpdateRequest), HttpStatus.OK);
    }

}