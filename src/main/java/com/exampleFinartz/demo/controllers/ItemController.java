package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.entities.Item;
import com.exampleFinartz.demo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        return new ResponseEntity<Item>(itemService.create(item), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Item> update(@RequestBody Item item) {
        return new ResponseEntity<Item>(itemService.update(item), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> get(@PathVariable Long id) {
        return new ResponseEntity<Item>(itemService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAll() {
        return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        itemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
