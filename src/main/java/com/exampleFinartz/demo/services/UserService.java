package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.request.create.UserCreateRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public interface UserService {

//    @Override
//    UserDetails loadUserByUsername(String email);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    UserDTO getUser(Long id);

    UserDTO getUser(String email);

    UserDTO createUser(UserCreateRequest userCreateRequest);


    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}