package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Address;
import com.exampleFinartz.demo.entity.City;
import lombok.Data;

@Data
public class CountyDTO {
    private long id;
    private String name;
    private City city;
    private Address address;

    public void setAddress(AddressDTO convert) {
    }

    public void setCity(CityDTO convert) {
    }
}
