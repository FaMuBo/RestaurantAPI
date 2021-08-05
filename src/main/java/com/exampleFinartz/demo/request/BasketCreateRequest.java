package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.Meal;
import com.exampleFinartz.demo.entity.Orders;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class BasketCreateRequest {

    private Long id;
    private Double totalprice;
    private List<Meal> mealList;
    private User user;
    private List<Orders> orders;
}
