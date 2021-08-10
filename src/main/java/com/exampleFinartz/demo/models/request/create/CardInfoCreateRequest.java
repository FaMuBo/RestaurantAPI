package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.UserDTO;
import lombok.Data;

@Data
public class CardInfoCreateRequest {
    private long id;
    private String card_no;
    private String name;
    private String exp_year;
    private String exp_month;
    private String cvv;
    private UserDTO user;
}
