package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.dto.CityDTO;
import com.exampleFinartz.demo.services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CityDTO> getCity(@PathVariable Long id) {
        return new ResponseEntity(cityService.getCity(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> getCities() {
        return new ResponseEntity(cityService.getCities(), HttpStatus.OK);
    }

}