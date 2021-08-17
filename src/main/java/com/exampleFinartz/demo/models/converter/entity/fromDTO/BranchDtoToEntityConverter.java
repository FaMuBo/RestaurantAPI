package com.exampleFinartz.demo.models.converter.entity.fromDTO;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchDtoToEntityConverter implements GenericConverter<BranchDTO, BranchEntity> {

    private final GenericConverter<RestaurantsDTO, RestaurantsEntity> restaurantEntityConverter;

    @Override
    public BranchEntity convert(final BranchDTO branch) {
        if (branch == null) {
            return null;
        }

        BranchEntity branchEntity = new BranchEntity();

        branchEntity.setId(branch.getId());
        branchEntity.setName(branch.getName());
        branchEntity.setPosition(branch.getPosition());
        branchEntity.setRestaurantEntity(convert(branch.getRestaurants()));


        return branchEntity;
    }

    private RestaurantsEntity convert(final RestaurantsDTO restaurant) {
        return restaurantEntityConverter.convert(restaurant);
    }

}