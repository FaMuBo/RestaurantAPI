package com.exampleFinartz.demo.models.converter.entity.fromDTO;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantsDtoToEntityConverter implements GenericConverter<RestaurantsDTO, RestaurantsEntity> {

    private final GenericConverter<UserDTO, UserEntity> userEntityConverter;
//    private final GenericConverter<BranchDto, BranchEntity> branchEntityConverter;

    @Override
    public RestaurantsEntity convert(final RestaurantsDTO restaurant) {
        if (restaurant == null) {
            return null;
        }

        RestaurantsEntity restaurantEntity = new RestaurantsEntity();

        restaurantEntity.setId(restaurant.getId());
        restaurantEntity.setName(restaurant.getName());
        restaurantEntity.setPosition(restaurant.getPosition());
        restaurantEntity.setUserEntity(convert(restaurant.getUser()));

        return restaurantEntity;
    }

    private UserEntity convert(final UserDTO user) {
        return userEntityConverter.convert(user);
    }


}
