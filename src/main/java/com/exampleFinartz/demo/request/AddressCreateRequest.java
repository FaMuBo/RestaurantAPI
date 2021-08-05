package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.City;
import com.exampleFinartz.demo.entity.County;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;


@Data
public class AddressCreateRequest {

    private Long id;
    private String name;
    private City city;
    private County county;
    private User user;
    private Branch branch;
    private String district;
    private String other_content;
    private Boolean enable;
}
