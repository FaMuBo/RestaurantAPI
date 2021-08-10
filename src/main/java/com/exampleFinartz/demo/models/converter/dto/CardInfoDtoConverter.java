package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.CardInfoDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.CardInfoEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class CardInfoDtoConverter implements GenericConverter<CardInfoEntity, CardInfoDTO> {

    private final GenericConverter<UserEntity, UserDTO> userDtoConverter;


    @Override
    public CardInfoDTO convert(final CardInfoEntity cardInfoEntity) {
        if (cardInfoEntity == null) {
            return null;
        }

        CardInfoDTO cardInfo1 = new CardInfoDTO();

        cardInfo1.setId(cardInfo1.getId());
        cardInfo1.setUser(convert(cardInfoEntity.getUserEntity()));

        return cardInfo1;

    }

    private UserDTO convert(final UserEntity userEntity) {
        return userDtoConverter.convert(userEntity);
    }


}