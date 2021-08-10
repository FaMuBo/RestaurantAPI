package com.exampleFinartz.demo.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class BasketDTO {

    private Long id;
    private Double totalprice;
    private List<MealDTO> mealDTOList;
    private UserDTO user;
    private List<OrdersDTO> ordersDTOList;


//    public void setUserEntity(UserDTO convert) {
//    }
}
