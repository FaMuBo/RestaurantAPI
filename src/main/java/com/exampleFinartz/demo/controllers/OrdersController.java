package com.exampleFinartz.demo.controllers;


import com.exampleFinartz.demo.models.entity.OrdersEntity;
import com.exampleFinartz.demo.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordersEntity")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity<OrdersEntity> create(@RequestBody OrdersEntity ordersEntity) {
        return new ResponseEntity<OrdersEntity>(ordersService.create(ordersEntity), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrdersEntity> update(@RequestBody OrdersEntity ordersEntity) {
        return new ResponseEntity<OrdersEntity>(ordersService.update(ordersEntity), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrdersEntity> get(@PathVariable Long id) {
        return new ResponseEntity<OrdersEntity>(ordersService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrdersEntity>> getAll() {
        return new ResponseEntity<>(ordersService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        ordersService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
