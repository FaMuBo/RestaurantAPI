package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.*;
import com.exampleFinartz.demo.enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserCreateRequest {

    private long id;
    private long password;
    private String name;
    private Role role;
    private Basket basket;
    private String email;
    private List<CardInfo> cardi̇nfo;
    private List<Address> adress;
    private List<Comments> comments;
    private List<Restaurants> restaurants;
}
