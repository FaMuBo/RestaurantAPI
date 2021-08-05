package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.entity.County;
import com.exampleFinartz.demo.services.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/county")
public class CountyController {

    @Autowired
    private CountyService countyService;

    @PostMapping
    public ResponseEntity<County> create(@RequestBody County county) {
        return new ResponseEntity<County>(countyService.create(county), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<County> update(@RequestBody County county) {
        return new ResponseEntity<County>(countyService.update(county), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<County> get(@PathVariable Long id) {
        return new ResponseEntity<County>(countyService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<County>> getAll() {
        return new ResponseEntity<>(countyService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        countyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
