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
public class CountyDtoConverter implements GenericConverter<County, CountyDTO> {

    private final GenericConverter<Address, AddressDTO> addressDtoConverter;
    private final GenericConverter<City, CityDTO> cityDtoConverter;

    @Override
    public CountyDTO convert(final County county) {
        if (county == null) {
            return null;
        }

        CountyDTO county1 = new CountyDTO();

        county1.setId(county1.getId());
        county1.setAddress(convert(county1.getAddress()));
        county1.setCity(convert(county1.getCity()));
        county1.setName(county1.getName());

        return county1;

    }

    private AddressDTO convert(final Address address) {
        return addressDtoConverter.convert(address);
    }

    private CityDTO convert(final City city) {
        return cityDtoConverter.convert(city);
    }
}