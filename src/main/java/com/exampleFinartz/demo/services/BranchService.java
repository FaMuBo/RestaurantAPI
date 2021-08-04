package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Branch;
import com.exampleFinartz.demo.enums.Position;

import java.util.List;



public interface BranchService {

    public Branch create(Branch branch);

    public List<Branch> getAll();

    public Branch getById(Long id);

    public List<Branch> findByAddress_County_Id(Long county_id);

    public Branch update(Branch branch);

    public Branch deleteById(Long id);

    public List<Branch> getByStatus(Position position);

    String delete(Long id);

}


