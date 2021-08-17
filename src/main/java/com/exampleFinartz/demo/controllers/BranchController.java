package com.exampleFinartz.demo.controllers;


import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.request.create.BranchCreateRequest;
import com.exampleFinartz.demo.services.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("branch")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BranchEntity> getBranch(@PathVariable Long id) {
        return new ResponseEntity(branchService.getBranch(id), HttpStatus.OK);
    }

    @GetMapping("county")
    public ResponseEntity<List<BranchEntity>> getBranches(@RequestParam Long countyId) {
        return new ResponseEntity(branchService.getBranches(countyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BranchEntity> createBranch(@Valid @RequestBody BranchCreateRequest branchCreateRequest) {
        return new ResponseEntity(branchService.createBranch(branchCreateRequest), HttpStatus.CREATED);
    }

}
