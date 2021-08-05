package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.City;
import com.exampleFinartz.demo.entity.County;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private String name;
    private City city;
    private County county;
    private User user;
    private Branch branch;
    private String district;
    private String other_content;
    private Boolean enable;

    public void setCounty(CountyDTO convert) {
    }

    public void setBranch(BranchDTO convert) {
    }

    public void setCity(CityDTO convert) {
    }

    public void setUser(UserDTO convert) {
    }
}
