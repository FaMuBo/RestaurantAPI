package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.entity.BasketEntity;
import com.exampleFinartz.demo.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @PostMapping
    public ResponseEntity<BasketEntity> create(@RequestBody BasketEntity basketEntity) {
        return new ResponseEntity(basketService.create(basketEntity), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BasketEntity> get(@PathVariable Long id) {
        return new ResponseEntity(basketService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BasketEntity>> getAll() {
        return new ResponseEntity(basketService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BasketEntity> update(@RequestBody BasketEntity basketEntity) {
        return new ResponseEntity(basketService.update(basketEntity), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BasketEntity> deleteById(@PathVariable Long id) {
        basketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}