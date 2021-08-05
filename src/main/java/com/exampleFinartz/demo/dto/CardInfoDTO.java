package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.User;
import lombok.Data;

@Data
public class CardInfoDTO {
    private long id;
    private String card_no;
    private String name;
    private String exp_year;
    private String exp_month;
    private String cvv;
    private User user;

    public void setUser(UserDTO convert) {
    }
}
