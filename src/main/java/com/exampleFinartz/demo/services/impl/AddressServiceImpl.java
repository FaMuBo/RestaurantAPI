package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.AddressDtoConverter;
import com.exampleFinartz.demo.models.converter.entity.fromCreateRequest.AddressCreateRequestToEntityConverter;
import com.exampleFinartz.demo.models.dto.AddressDTO;
import com.exampleFinartz.demo.models.entity.AddressEntity;
import com.exampleFinartz.demo.models.request.create.AddressCreateRequest;
import com.exampleFinartz.demo.repositories.AddressRepository;
import com.exampleFinartz.demo.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressDtoConverter addressDtoConverter;
    private final AddressCreateRequestToEntityConverter addressCreateRequestToEntityConverter;

    @Override
    public AddressDTO getAddress(Long id) {
        AddressEntity addressEntity = addressRepository.getById(id);
        return addressDtoConverter.convert(addressEntity);
    }

    @Override
    public AddressDTO createAddress(AddressCreateRequest addressCreateRequest) {
        AddressEntity addressEntity = addressCreateRequestToEntityConverter.convert(addressCreateRequest);
        return addressDtoConverter.convert(addressRepository.save(addressEntity));
    }

}

