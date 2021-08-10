package com.exampleFinartz.demo.models.dto;

import lombok.Data;

@Data
public class CardInfoDTO {
    private long id;
    private String card_no;
    private String name;
    private String exp_year;
    private String exp_month;
    private String cvv;
    private UserDTO user;

//    public void setUserEntity(UserDTO convert) {
//    }
}
