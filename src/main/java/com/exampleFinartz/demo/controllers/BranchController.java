package com.exampleFinartz.demo.controllers;


import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.enums.Position;
import com.exampleFinartz.demo.models.request.create.BranchCreateRequest;
import com.exampleFinartz.demo.models.request.update.BranchUpdateRequest;
import com.exampleFinartz.demo.services.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("waiting")
    public ResponseEntity<List<BranchEntity>> getBranches(Position position) {
        return new ResponseEntity(branchService.getBranches(position), HttpStatus.OK);
    }

    @GetMapping("by-county")
    public ResponseEntity<List<BranchEntity>> getBranches(Long countyId) {
        return new ResponseEntity(branchService.getBranches(countyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BranchEntity> createBranch(@RequestBody BranchCreateRequest branchCreateRequest) {
        return new ResponseEntity(branchService.createBranch(branchCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<BranchEntity> updateBranch(@PathVariable Long id, @RequestBody BranchUpdateRequest branchUpdateRequest) {
        return new ResponseEntity(branchService.updateBranch(id, branchUpdateRequest), HttpStatus.OK);
    }

}
