package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.request.create.MenuCreateRequest;
import com.exampleFinartz.demo.models.request.update.MenuUpdateRequest;
import com.exampleFinartz.demo.services.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("{id}")
    public ResponseEntity<MenuDTO> getMenu(@PathVariable Long id) {
        return new ResponseEntity(menuService.getMenu(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MenuDTO> createMenu(@RequestBody MenuCreateRequest menuCreateRequest) {
        return new ResponseEntity(menuService.createMenu(menuCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<MenuDTO> updateMenu(@PathVariable Long id, @RequestBody MenuUpdateRequest menuUpdateRequest) {
        return new ResponseEntity(menuService.updateMenu(id, menuUpdateRequest), HttpStatus.OK);
    }

}