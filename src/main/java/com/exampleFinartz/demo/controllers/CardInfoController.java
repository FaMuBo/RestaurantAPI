package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.entity.CardInfo;
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
    public ResponseEntity<CardInfo> create(@RequestBody CardInfo cardinfo) {
        return new ResponseEntity<CardInfo>(cardinfoService.create(cardinfo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CardInfo> update(@RequestBody CardInfo cardinfo) {
        return new ResponseEntity<CardInfo>(cardinfoService.update(cardinfo), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CardInfo> get(@PathVariable Long id) {
        return new ResponseEntity<CardInfo>(cardinfoService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CardInfo>> getAll() {
        return new ResponseEntity<>(cardinfoService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        cardinfoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
