package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.*;
import com.exampleFinartz.demo.enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private long id;
    private long password;
    private String name;
    private Role role;
    private Basket basket;
    private String email;
    private List<CardInfo> cardi̇nfo;
    private List<Address> address;
    private List<Comments> comments;
    private List<Restaurants> restaurants;

    public void setBasket(BasketDTO convert) {
    }
}
