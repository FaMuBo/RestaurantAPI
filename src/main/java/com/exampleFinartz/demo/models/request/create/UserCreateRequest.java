package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.*;
import com.exampleFinartz.demo.models.enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserCreateRequest {

    private long id;
    private long password;
    private String name;
    private Role role;
    private BasketDTO basket;
    private String email;
    private List<CardInfoDTO> cardInfoDTOList;
    private List<AddressDTO> addressDTOList;
    private List<CommentsDTO> commentsDTOList;
    private List<RestaurantsDTO> restaurantsDTOList;
}
