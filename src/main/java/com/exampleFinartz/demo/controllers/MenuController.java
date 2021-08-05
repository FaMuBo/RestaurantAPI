package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.entity.Menu;
import com.exampleFinartz.demo.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<Menu> create(@RequestBody Menu menu) {
        return new ResponseEntity<Menu>(menuService.create(menu), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Menu> update(@RequestBody Menu menu) {
        return new ResponseEntity<Menu>(menuService.update(menu), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Menu> get(@PathVariable Long id) {
        return new ResponseEntity<Menu>(menuService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAll() {
        return new ResponseEntity<>(menuService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        menuService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
