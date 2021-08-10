package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.AddressDTO;
import com.exampleFinartz.demo.models.dto.CountyDTO;
import lombok.Data;

import java.util.List;

@Data
public class CityCreateRequest {
    private long id;
    private String name;
    private AddressDTO address;
    private List<CountyDTO> countyDTOList;
}
