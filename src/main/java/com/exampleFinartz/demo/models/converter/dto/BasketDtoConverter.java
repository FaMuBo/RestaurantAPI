package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BasketDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.BasketEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BasketDtoConverter implements GenericConverter<BasketEntity, BasketDTO> {

    private final GenericConverter<UserEntity, UserDTO> userDtoConverter;

    @Override
    public BasketDTO convert(final BasketEntity basketEntity) {
        if (basketEntity == null) {
            return null;
        }

        BasketDTO basket1 = new BasketDTO();

        basket1.setId(basket1.getId());

        basket1.setUser(convert(basketEntity.getUserEntity()));

        return basket1;

    }

    private UserDTO convert(final UserEntity userEntity) {
        return userDtoConverter.convert(userEntity);
    }


}

