package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Meal;
import com.exampleFinartz.demo.entity.Orders;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class BasketDTO {

    private Long id;
    private Double totalprice;
    private List<Meal> mealList;
    private User user;
    private List<Orders> orders;

    public void setUser(UserDTO convert) {
    }
}
