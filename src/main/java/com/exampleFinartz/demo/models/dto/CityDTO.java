package com.exampleFinartz.demo.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class CityDTO {
    private long id;
    private String name;
    private AddressDTO addressDTO;
    private List<CountyDTO> countyDTOList;

//    public void setAddressEntity(AddressDTO convert) {
//    }
}
