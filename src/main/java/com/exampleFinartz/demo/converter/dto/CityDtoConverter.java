package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.AddressDTO;
import com.exampleFinartz.demo.dto.CityDTO;
import com.exampleFinartz.demo.dto.CountyDTO;
import com.exampleFinartz.demo.entity.Address;
import com.exampleFinartz.demo.entity.City;
import com.exampleFinartz.demo.entity.County;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CityDtoConverter implements GenericConverter<City, CityDTO> {

    private final GenericConverter<Address, AddressDTO> addressDtoConverter;
    private final GenericConverter<County, CountyDTO> countyDtoConverter;

    @Override
    public CityDTO convert(final City city) {
        if (city == null) {
            return null;
        }

        CityDTO city1 = new CityDTO();

        city1.setId(city1.getId());
        city1.setAddress(convert(city1.getAddress()));
        //  city1.setCounty(convert(city1.getCounty()));
        city1.setName(city1.getName());


        return city1;

    }

    private AddressDTO convert(final Address address) {
        return addressDtoConverter.convert(address);
    }

    private CountyDTO convert(final County county) {
        return countyDtoConverter.convert(county);
    }


}
