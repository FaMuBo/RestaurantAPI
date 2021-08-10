package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.AddressDTO;
import com.exampleFinartz.demo.models.dto.CityDTO;
import lombok.Data;

@Data
public class CountyCreateRequest {
    private long id;
    private String name;
    private CityDTO city;
    private AddressDTO address;
}
