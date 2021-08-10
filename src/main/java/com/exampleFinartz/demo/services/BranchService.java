package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.enums.Position;
import com.exampleFinartz.demo.models.request.create.BranchCreateRequest;
import com.exampleFinartz.demo.models.request.update.BranchUpdateRequest;

import java.util.List;



public interface BranchService {

    BranchDTO getBranch(Long id);

    List<BranchDTO> getBranches(Position position);

    List<BranchDTO> getBranches(Long countyId);

    BranchDTO createBranch(BranchCreateRequest branchCreateRequest);

    BranchDTO updateBranch(Long id, BranchUpdateRequest branchUpdateRequest);


}


