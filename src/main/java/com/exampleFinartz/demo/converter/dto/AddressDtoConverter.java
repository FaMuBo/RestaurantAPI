package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.*;
import com.exampleFinartz.demo.entity.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AddressDtoConverter implements GenericConverter<Address, AddressDTO> {

    private final GenericConverter<City, CityDTO> cityDtoConverter;
    private final GenericConverter<County, CountyDTO> countyDtoConverter;
    private final GenericConverter<User, UserDTO> userDtoConverter;
    private final GenericConverter<Branch, BranchDTO> branchDtoConverter;

    @Override
    public AddressDTO convert(final Address address) {
        if (address == null) {
            return null;
        }

        AddressDTO address1 = new AddressDTO();

        address1.setId(address.getId());
        address1.setName(address.getName());
        address1.setCity(convert(address1.getCity()));
        address1.setCounty(convert(address1.getCounty()));
        address1.setDistrict(address1.getDistrict());
        address1.setOther_content(address1.getOther_content());
        address1.setUser(convert(address1.getUser()));
        address1.setBranch(convert(address1.getBranch()));

        return address1;

    }


    private CityDTO convert(final City city) {
        return cityDtoConverter.convert(city);
    }

    private CountyDTO convert(final County county) {
        return countyDtoConverter.convert(county);
    }

    private UserDTO convert(final User user) {
        return userDtoConverter.convert(user);
    }

    private BranchDTO convert(final Branch branch) {
        return branchDtoConverter.convert(branch);
    }

}
