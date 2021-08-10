package com.exampleFinartz.demo.models.converter.entity.fromCreateRequest;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import com.exampleFinartz.demo.models.request.create.RestaurantsCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantsCreateRequestToEntityConverter implements GenericConverter<RestaurantsCreateRequest, RestaurantsEntity> {

    private final GenericConverter<UserDTO, UserEntity> userEntityConverter;
    private final GenericConverter<BranchDTO, BranchEntity> branchEntityConverter;

    @Override
    public RestaurantsEntity convert(final RestaurantsCreateRequest restaurantCreateRequest) {
        if (restaurantCreateRequest == null) {
            return null;
        }

        RestaurantsEntity restaurantEntity = new RestaurantsEntity();

        restaurantEntity.setName(restaurantCreateRequest.getName());
        restaurantEntity.setPosition(restaurantCreateRequest.getPosition());
        restaurantEntity.setUserEntity(convert(restaurantCreateRequest.getUser()));

        List<BranchEntity> branchEntities = new ArrayList<>();
        restaurantCreateRequest.getBranchDTOList().forEach(branch -> {
            branchEntities.add(convert(branch));
        });
        restaurantEntity.setBranchEntities(branchEntities);

        return restaurantEntity;
    }

    private UserEntity convert(final UserDTO user) {
        return userEntityConverter.convert(user);
    }

    private BranchEntity convert(final BranchDTO branch) {
        return branchEntityConverter.convert(branch);
    }

}
