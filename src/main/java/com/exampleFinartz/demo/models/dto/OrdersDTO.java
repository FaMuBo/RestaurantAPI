package com.exampleFinartz.demo.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrdersDTO {
    private long id;
    private int amount;
    private Date date;
    private BasketDTO basket;

//    public void setBasketEntity(BasketDTO convert) {
//    }
}
