package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.Basket;
import lombok.Data;

import java.util.Date;

@Data
public class OrdersCreateRequest {
    private long id;
    private int amount;
    private Date date;
    private Basket basket;
}
