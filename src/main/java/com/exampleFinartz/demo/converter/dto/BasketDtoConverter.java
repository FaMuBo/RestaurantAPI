package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.BasketDTO;
import com.exampleFinartz.demo.dto.UserDTO;
import com.exampleFinartz.demo.entity.Basket;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BasketDtoConverter implements GenericConverter<Basket, BasketDTO> {

    private final GenericConverter<User, UserDTO> userDtoConverter;

    @Override
    public BasketDTO convert(final Basket basket) {
        if (basket == null) {
            return null;
        }

        BasketDTO basket1 = new BasketDTO();

        basket1.setId(basket1.getId());

        basket1.setUser(convert(basket1.getUser()));

        return basket1;

    }


    private UserDTO convert(final User user) {
        return userDtoConverter.convert(user);
    }


}

