package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Address;
import com.exampleFinartz.demo.entity.County;
import lombok.Data;

import java.util.List;

@Data
public class CityDTO {
    private long id;
    private String name;
    private Address address;
    private List<County> county;

    public void setAddress(AddressDTO convert) {
    }
}
