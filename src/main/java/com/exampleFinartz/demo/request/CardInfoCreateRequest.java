package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.User;
import lombok.Data;

@Data
public class CardInfoCreateRequest {
    private long id;
    private String card_no;
    private String name;
    private String exp_year;
    private String exp_month;
    private String cvv;
    private User user;
}
