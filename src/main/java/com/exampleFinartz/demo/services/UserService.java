package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.request.create.UserCreateRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
//    @Override
//    UserDetails loadUserByUsername(String email);

    UserDTO getUser(Long id);

    UserDTO getUser(String email);

    UserDTO createUser(UserCreateRequest userCreateRequest);


}