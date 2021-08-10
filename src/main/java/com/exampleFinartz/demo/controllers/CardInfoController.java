package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.entity.CardInfoEntity;
import com.exampleFinartz.demo.services.CardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-info")
public class CardInfoController {


    @Autowired
    private CardInfoService cardinfoService;

    @PostMapping
    public ResponseEntity<CardInfoEntity> create(@RequestBody CardInfoEntity cardinfo) {
        return new ResponseEntity<CardInfoEntity>(cardinfoService.create(cardinfo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CardInfoEntity> update(@RequestBody CardInfoEntity cardinfo) {
        return new ResponseEntity<CardInfoEntity>(cardinfoService.update(cardinfo), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CardInfoEntity> get(@PathVariable Long id) {
        return new ResponseEntity<CardInfoEntity>(cardinfoService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CardInfoEntity>> getAll() {
        return new ResponseEntity<>(cardinfoService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        cardinfoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
