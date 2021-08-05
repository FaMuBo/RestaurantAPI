package com.exampleFinartz.demo.controllers;


import com.exampleFinartz.demo.entity.Orders;
import com.exampleFinartz.demo.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody Orders orders) {
        return new ResponseEntity<Orders>(ordersService.create(orders), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Orders> update(@RequestBody Orders orders) {
        return new ResponseEntity<Orders>(ordersService.update(orders), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Orders> get(@PathVariable Long id) {
        return new ResponseEntity<Orders>(ordersService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAll() {
        return new ResponseEntity<>(ordersService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        ordersService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
