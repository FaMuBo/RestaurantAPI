package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.*;
import com.exampleFinartz.demo.entity.*;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class UserDtoConverter implements GenericConverter<User, UserDTO> {

    private final GenericConverter<City, CityDTO> cityDtoConverter;
    private final GenericConverter<Restaurants, RestaurantsDTO> restaurantsDtoConverter;
    private final GenericConverter<CardInfo, CardInfoDTO> cardInfoDtoConverter;
    private final GenericConverter<Comments, CommentsDTO> commentsDtoConverter;
    private final GenericConverter<Basket, BasketDTO> basketDtoConverter;
    private final GenericConverter<Address, AddressDTO> addressDtoConverter;


    @Override
    public UserDTO convert(final User user) {
        if (user == null) {
            return null;
        }

        UserDTO user1 = new UserDTO();

        user1.setId(user1.getId());
        //user1.setAddress(convert(user1.getAddress()));
        user1.setBasket(convert(user1.getBasket()));
        user1.setName(user1.getName());
        user1.setEmail(user1.getEmail());
        user1.setPassword(user1.getPassword());
        user1.setRole(user1.getRole());

        return user1;

    }

    private BasketDTO convert(final Basket basket) {
        return basketDtoConverter.convert(basket);
    }

}

