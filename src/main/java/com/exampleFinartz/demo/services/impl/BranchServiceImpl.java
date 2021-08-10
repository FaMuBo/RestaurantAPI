package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.BranchDtoConverter;
import com.exampleFinartz.demo.models.converter.entity.fromCreateRequest.BranchCreateRequestToEntityConverter;
import com.exampleFinartz.demo.models.converter.entity.fromUpdateRequest.BranchUpdateRequestToEntityConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.enums.Position;
import com.exampleFinartz.demo.models.request.create.BranchCreateRequest;
import com.exampleFinartz.demo.models.request.update.BranchUpdateRequest;
import com.exampleFinartz.demo.repositories.BranchRepository;
import com.exampleFinartz.demo.services.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    private final BranchCreateRequestToEntityConverter branchCreateRequestToEntityConverter;
    private final BranchUpdateRequestToEntityConverter branchUpdateRequestToEntityConverter;
    private final BranchDtoConverter branchDtoConverter;

    @Override
    public BranchDTO getBranch(Long id) {
        return branchDtoConverter.convert(branchRepository.getById(id));
    }

    @Override
    public List<BranchDTO> getBranches(Position position) {
        List<BranchDTO> branches = new ArrayList<>();
        branchRepository.getBranchEntitiesByPosition(position).forEach(branchEntity -> {
            branches.add(branchDtoConverter.convert(branchEntity));
        });
        return branches;
    }

    @Override
    public List<BranchDTO> getBranches(Long countyId) {
        List<BranchDTO> branches = new ArrayList<>();
        branchRepository.getBranchEntitiesByAddressEntity_CountyEntity_Id(countyId).forEach(branchEntity -> {
            branches.add(branchDtoConverter.convert(branchEntity));
        });
        return branches;
    }

    @Override
    public BranchDTO createBranch(BranchCreateRequest branchCreateRequest) {
        BranchEntity branchEntity = branchCreateRequestToEntityConverter.convert(branchCreateRequest);
        return branchDtoConverter.convert(branchRepository.save(branchEntity));
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchUpdateRequest branchUpdateRequest) {
        BranchEntity branchExisted = branchRepository.getById(id);

        BranchEntity branchUpdated =
                branchUpdateRequestToEntityConverter.convert(branchUpdateRequest, branchExisted);

        return branchDtoConverter.convert(branchRepository.save(branchUpdated));
    }
}


