package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.dto.ItemDTO;
import com.exampleFinartz.demo.models.request.create.ItemCreateRequest;
import com.exampleFinartz.demo.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable Long id) {
        return new ResponseEntity(itemService.getItem(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getItems(@RequestParam(defaultValue = "0") Integer pageNo,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity(itemService.getItems(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemCreateRequest itemCreateRequest) {
        return new ResponseEntity(itemService.createItem(itemCreateRequest), HttpStatus.CREATED);
    }

}