package com.exampleFinartz.demo.models.converter.entity.fromDTO;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoToEntityConverter implements GenericConverter<UserDTO, UserEntity> {

//    private final GenericConverter<AddressDto, AddressEntity> addressEntityConverter;
//    private final GenericConverter<RestaurantDto, RestaurantEntity> restaurantEntityConverter;
//    private final GenericConverter<CommentDto, CommentEntity> commentEntityConverter;

    @Override
    public UserEntity convert(final UserDTO user) {
        if (user == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());

        return userEntity;
    }

}