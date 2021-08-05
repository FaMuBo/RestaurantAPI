package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.Address;
import com.exampleFinartz.demo.entity.County;
import lombok.Data;

import java.util.List;

@Data
public class CityCreateRequest {
    private long id;
    private String name;
    private Address address;
    private List<County> county;
}
