package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.CardInfoDTO;
import com.exampleFinartz.demo.dto.UserDTO;
import com.exampleFinartz.demo.entity.CardInfo;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class CardInfoDtoConverter implements GenericConverter<CardInfo, CardInfoDTO> {

    private final GenericConverter<User, UserDTO> userDtoConverter;


    @Override
    public CardInfoDTO convert(final CardInfo cardInfo) {
        if (cardInfo == null) {
            return null;
        }

        CardInfoDTO cardInfo1 = new CardInfoDTO();

        cardInfo1.setId(cardInfo1.getId());
        cardInfo1.setUser(convert(cardInfo1.getUser()));

        return cardInfo1;

    }

    private UserDTO convert(final User user) {
        return userDtoConverter.convert(user);
    }


}