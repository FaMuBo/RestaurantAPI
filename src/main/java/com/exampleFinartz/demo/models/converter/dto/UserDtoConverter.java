package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.*;
import com.exampleFinartz.demo.models.entity.*;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class UserDtoConverter implements GenericConverter<UserEntity, UserDTO> {

    private final GenericConverter<CityEntity, CityDTO> cityDtoConverter;
    private final GenericConverter<RestaurantsEntity, RestaurantsDTO> restaurantsDtoConverter;
    private final GenericConverter<CardInfoEntity, CardInfoDTO> cardInfoDtoConverter;
    private final GenericConverter<CommentsEntity, CommentsDTO> commentsDtoConverter;
    private final GenericConverter<BasketEntity, BasketDTO> basketDtoConverter;
    private final GenericConverter<AddressEntity, AddressDTO> addressDtoConverter;


    @Override
    public UserDTO convert(final UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        UserDTO user1 = new UserDTO();

        user1.setId(user1.getId());
        //user1.setAddress(convert(user1.getAddress()));
        user1.setBasket(convert(userEntity.getBasketEntity()));
        user1.setName(user1.getName());
        user1.setEmail(user1.getEmail());
        user1.setPassword(user1.getPassword());
//        user1.setRole(userEntity.getRole());

        return user1;

    }

    private BasketDTO convert(final BasketEntity basketEntity) {
        return basketDtoConverter.convert(basketEntity);
    }

}

