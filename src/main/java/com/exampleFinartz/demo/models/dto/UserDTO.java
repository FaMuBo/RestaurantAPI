package com.exampleFinartz.demo.models.dto;

import com.exampleFinartz.demo.models.enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;

    private String email;

    private Long password;

    private String name;

    private List<Role> roles;

    private BasketDTO basket;

//    public void setBasketEntity(BasketDTO convert) {
//    }
}
