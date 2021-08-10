package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.BasketDTO;
import lombok.Data;

import java.util.Date;

@Data
public class OrdersCreateRequest {
    private long id;
    private int amount;
    private Date date;
    private BasketDTO basketDTO;
}
