package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.CityDTO;
import com.exampleFinartz.demo.models.dto.CountyDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import lombok.Data;


@Data
public class AddressCreateRequest {

    private Long id;
    private String name;
    private CityDTO city;
    private CountyDTO county;
    private UserDTO user;
    private BranchDTO branch;
    private String district;
    private String other_content;
}
