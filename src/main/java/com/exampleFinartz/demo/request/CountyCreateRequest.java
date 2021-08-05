package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.Address;
import com.exampleFinartz.demo.entity.City;
import lombok.Data;

@Data
public class CountyCreateRequest {
    private long id;
    private String name;
    private City city;
    private Address address;
}
