package com.exampleFinartz.demo.models.converter.entity.fromCreateRequest;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.AddressDTO;
import com.exampleFinartz.demo.models.dto.CommentsDTO;
import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.entity.AddressEntity;
import com.exampleFinartz.demo.models.entity.CommentsEntity;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import com.exampleFinartz.demo.models.request.create.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserCreateRequestToEntityConverter implements GenericConverter<UserCreateRequest, UserEntity> {

    private final GenericConverter<AddressDTO, AddressEntity> addressEntityConverter;
    private final GenericConverter<RestaurantsDTO, RestaurantsEntity> restaurantEntityConverter;
    private final GenericConverter<CommentsDTO, CommentsEntity> commentEntityConverter;

    @Override
    public UserEntity convert(final UserCreateRequest userCreateRequest) {
        if (userCreateRequest == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setName(userCreateRequest.getName());
        userEntity.setEmail(userCreateRequest.getEmail());
        userEntity.setPassword(userCreateRequest.getPassword());

        List<AddressEntity> addressEntities = new ArrayList<>();
        userCreateRequest.getAddressDTOList().forEach(address -> {
            addressEntities.add(convert(address));
        });
        userEntity.setAddressEntities(addressEntities);

        List<RestaurantsEntity> restaurantEntities = new ArrayList<>();
        userCreateRequest.getRestaurantsDTOList().forEach(restaurant -> {
            restaurantEntities.add(convert(restaurant));
        });
        userEntity.setRestaurantsEntities(restaurantEntities);

        List<CommentsEntity> commentEntities = new ArrayList<>();
        userCreateRequest.getCommentsDTOList().forEach(comment -> {
            commentEntities.add(convert(comment));
        });
        userEntity.setCommentsEntities(commentEntities);

        return userEntity;
    }

    private AddressEntity convert(final AddressDTO address) {
        return addressEntityConverter.convert(address);
    }

    private RestaurantsEntity convert(final RestaurantsDTO restaurant) {
        return restaurantEntityConverter.convert(restaurant);
    }

    private CommentsEntity convert(final CommentsDTO comment) {
        return commentEntityConverter.convert(comment);
    }

}
