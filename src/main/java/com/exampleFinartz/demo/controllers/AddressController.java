package com.exampleFinartz.demo.controllers;


import com.exampleFinartz.demo.models.dto.AddressDTO;
import com.exampleFinartz.demo.models.request.create.AddressCreateRequest;
import com.exampleFinartz.demo.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable Long id) {
        return new ResponseEntity(addressService.getAddress(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressCreateRequest addressCreateRequest) {
        return new ResponseEntity(addressService.createAddress(addressCreateRequest), HttpStatus.CREATED);
    }

}