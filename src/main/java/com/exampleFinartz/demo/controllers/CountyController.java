package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.dto.CountyDTO;
import com.exampleFinartz.demo.services.CountyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("county")
public class CountyController {

    private final CountyService countyService;

    public CountyController(CountyService countyService) {
        this.countyService = countyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CountyDTO> getCounty(@PathVariable Long id) {
        return new ResponseEntity(countyService.getCounty(id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<CountyDTO>> getCounties(@RequestParam Long city_id) {
        return new ResponseEntity(countyService.getCounty(city_id), HttpStatus.OK);

    }
}