package com.exampleFinartz.demo.converter.dto;


import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.RestaurantsDTO;
import com.exampleFinartz.demo.dto.UserDTO;
import com.exampleFinartz.demo.entity.Restaurants;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RestaurantsDtoConverter implements GenericConverter<Restaurants, RestaurantsDTO> {

    private final GenericConverter<User, UserDTO> userDtoConverter;

    @Override
    public RestaurantsDTO convert(final Restaurants restaurants) {
        if (restaurants == null) {
            return null;
        }

        RestaurantsDTO restaurants1 = new RestaurantsDTO();

        restaurants1.setId(restaurants1.getId());
        restaurants1.setPosition(restaurants1.getPosition());
        restaurants1.setUser(convert(restaurants1.getUser()));
        restaurants1.setName(restaurants1.getName());

        return restaurants1;

    }

    private UserDTO convert(final User user) {
        return userDtoConverter.convert(user);
    }
}