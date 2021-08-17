package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.UserEntity;
import org.springframework.stereotype.Component;


@Component

public class UserDtoConverter implements GenericConverter<UserEntity, UserDTO> {

    @Override
    public UserDTO convert(final UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setRoles(userEntity.getRoles());

        return userDTO;
    }

}

