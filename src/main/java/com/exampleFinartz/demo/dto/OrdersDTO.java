package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Basket;
import lombok.Data;

import java.util.Date;

@Data
public class OrdersDTO {
    private long id;
    private int amount;
    private Date date;
    private Basket basket;

    public void setBasket(BasketDTO convert) {
    }
}
