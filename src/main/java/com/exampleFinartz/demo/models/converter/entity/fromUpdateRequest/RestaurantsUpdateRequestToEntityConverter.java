package com.exampleFinartz.demo.models.converter.entity.fromUpdateRequest;

import com.exampleFinartz.demo.models.converter.entity.fromDTO.BranchDtoToEntityConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.models.request.update.RestaurantsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantsUpdateRequestToEntityConverter {

    private final BranchDtoToEntityConverter branchDtoToEntityConverter;

    public RestaurantsEntity convert(final RestaurantsUpdateRequest restaurantUpdateRequest,
                                     final RestaurantsEntity restaurantExisted) {
        if (restaurantUpdateRequest == null)
            return null;

        if (restaurantUpdateRequest.getPosition() != null)
            restaurantExisted.setPosition(restaurantUpdateRequest.getPosition());

        if (restaurantUpdateRequest.getBranches() != null) {
            List<BranchEntity> branchEntities = new ArrayList<>();
            restaurantUpdateRequest.getBranches().forEach(branch -> {
                branchEntities.add(convert(branch));
            });
            restaurantExisted.setBranchEntities(branchEntities);
        }

        return restaurantExisted;
    }

    private BranchEntity convert(final BranchDTO branch) {
        return branchDtoToEntityConverter.convert(branch);
    }


}