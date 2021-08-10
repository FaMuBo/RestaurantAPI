package com.exampleFinartz.demo.models.dto;

import lombok.Data;

@Data
public class CountyDTO {
    private long id;
    private String name;
    private CityDTO city;
    private AddressDTO address;

//    public void setAddressEntity(AddressDTO convert) {
//    }
//
//    public void setCityEntity(CityDTO convert) {
//    }
}
