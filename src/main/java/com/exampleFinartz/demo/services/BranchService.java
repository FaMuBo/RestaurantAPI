package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Branch;
import com.exampleFinartz.demo.enums.Position;
import com.exampleFinartz.demo.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public Branch create(Branch branch) {
        Branch save = branchRepository.save(branch);
        return save;
    }

    public List<Branch> getAll() {
        List<Branch> branches = branchRepository.findAll();
        return branches;
    }

    public Branch getById(Long id) {
        return branchRepository.getById(id);
    }

    public List<Branch> getByStatus() {
        List<Branch> branches = branchRepository.findAllByPosition(Position.WAITING);
        return branches;
    }

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

    public Branch deleteById(Long id) {
        Branch branch = branchRepository.getById(id);
        if (branch != null) {
            branchRepository.deleteById(id);
            return branch;
        }
        return branch;
    }

    public List<Branch> findByAddress_County_Id(Long county_id) {

        return branchRepository.findByAddress_County_Id(county_id);
    }

    public List<Branch> getWaitingBranchList() {

        return branchRepository.findAllByPosition(Position.WAITING);
    }

    public String delete(long id) {
        branchRepository.deleteById(id);
        return "SUCCESS";
    }
}
