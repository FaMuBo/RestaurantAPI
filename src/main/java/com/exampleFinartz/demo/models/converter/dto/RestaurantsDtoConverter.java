package com.exampleFinartz.demo.models.converter.dto;


import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RestaurantsDtoConverter implements GenericConverter<RestaurantsEntity, RestaurantsDTO> {

    private final GenericConverter<UserEntity, UserDTO> userDtoConverter;

    @Override
    public RestaurantsDTO convert(final RestaurantsEntity restaurantsEntity) {
        if (restaurantsEntity == null) {
            return null;
        }

        RestaurantsDTO restaurants1 = new RestaurantsDTO();

        restaurants1.setId(restaurants1.getId());
        restaurants1.setPosition(restaurants1.getPosition());
        restaurants1.setUser(convert(restaurantsEntity.getUserEntity()));
        restaurants1.setName(restaurants1.getName());

        return restaurants1;

    }

    private UserDTO convert(final UserEntity userEntity) {
        return userDtoConverter.convert(userEntity);
    }
}