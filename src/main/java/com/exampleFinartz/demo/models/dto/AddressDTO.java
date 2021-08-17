package com.exampleFinartz.demo.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

    private Long id;
    private String name;
    private CityDTO city;
    private CountyDTO county;
    private UserDTO user;
    private BranchDTO branch;
    private String district;
    private String other_content;


//    public void setCountyEntity(CountyDTO convert) {
//    }
//
//    public void setBranchEntity(BranchDTO convert) {
//    }
//
//    public void setCityEntity(CityDTO convert) {
//    }
//
//    public void setUserEntity(UserDTO convert) {
//    }
}
