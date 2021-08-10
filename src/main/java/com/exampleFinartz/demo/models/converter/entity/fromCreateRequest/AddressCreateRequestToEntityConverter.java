package com.exampleFinartz.demo.models.converter.entity.fromCreateRequest;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.CityDTO;
import com.exampleFinartz.demo.models.dto.CountyDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.*;
import com.exampleFinartz.demo.models.request.create.AddressCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressCreateRequestToEntityConverter implements GenericConverter<AddressCreateRequest, AddressEntity> {

    private final GenericConverter<CityDTO, CityEntity> cityEntityConverter;
    private final GenericConverter<CountyDTO, CountyEntity> countyEntityConverter;
    private final GenericConverter<UserDTO, UserEntity> userEntityConverter;
    private final GenericConverter<BranchDTO, BranchEntity> branchEntityConverter;

    @Override
    public AddressEntity convert(final AddressCreateRequest addressCreateRequest) {
        if (addressCreateRequest == null) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setName(addressCreateRequest.getName());
        addressEntity.setDistrict(addressCreateRequest.getDistrict());
        addressEntity.setOther_content(addressCreateRequest.getOther_content());
        addressEntity.setCityEntity(convert(addressCreateRequest.getCity()));
        addressEntity.setCountyEntity(convert(addressCreateRequest.getCounty()));
        addressEntity.setUserEntity(convert(addressCreateRequest.getUser()));
        addressEntity.setBranchEntity(convert(addressCreateRequest.getBranch()));

        return addressEntity;

    }

    private CityEntity convert(final CityDTO city) {
        return cityEntityConverter.convert(city);
    }

    private CountyEntity convert(final CountyDTO county) {
        return countyEntityConverter.convert(county);
    }

    private UserEntity convert(final UserDTO user) {
        return userEntityConverter.convert(user);
    }

    private BranchEntity convert(final BranchDTO branch) {
        return branchEntityConverter.convert(branch);
    }

}
