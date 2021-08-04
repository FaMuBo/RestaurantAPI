package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entities.Branch;
import com.exampleFinartz.demo.enums.Position;
import com.exampleFinartz.demo.repositories.BranchRepository;
import com.exampleFinartz.demo.services.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch create(Branch branch) {
        Branch save = branchRepository.save(branch);
        return save;
    }

    @Override
    public List<Branch> getAll() {
        List<Branch> branches = branchRepository.findAll();
        return branches;
    }

    @Override
    public Branch getById(Long id) {
        return branchRepository.getById(id);
    }

    @Override
    public List<Branch> getByStatus(Position position) {
        return branchRepository.findAllByPosition(position);
    }

    @Override
    public Branch update(Branch branch) {
        Branch foundBranch = branchRepository.getById(branch.getId());
        if (branch.getPosition() != null) {
            foundBranch.setPosition(branch.getPosition());
        }
        if (branch.getName() != null) {
            foundBranch.setName(branch.getName());
        }
        if (branch.getRole() != null) {
            foundBranch.setRole(branch.getRole());
        }
        return branchRepository.save(branch);
    }

    @Override
    public Branch deleteById(Long id) {
        Branch branch = branchRepository.getById(id);
        if (branch != null) {
            branchRepository.deleteById(id);
            return branch;
        }
        return branch;
    }

    @Override
    public List<Branch> findByAddress_County_Id(Long county_id) {

        return branchRepository.findByAddress_County_Id(county_id);
    }

    public List<Branch> getWaitingBranchList() {

        return branchRepository.findAllByPosition(Position.WAITING);
    }

    @Override
    public String delete(Long id) {
        branchRepository.deleteById(id);
        return "SUCCESS";
    }
}


