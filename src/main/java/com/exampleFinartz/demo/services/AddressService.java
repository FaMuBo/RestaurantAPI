package com.exampleFinartz.demo.services;


import com.exampleFinartz.demo.models.dto.AddressDTO;
import com.exampleFinartz.demo.models.request.create.AddressCreateRequest;
import org.springframework.stereotype.Service;


@Service
public interface AddressService {

    AddressDTO getAddress(Long id);

    AddressDTO createAddress(AddressCreateRequest addressCreateRequest);

}

