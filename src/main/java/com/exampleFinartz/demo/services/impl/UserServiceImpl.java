package com.exampleFinartz.demo.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.exampleFinartz.demo.models.converter.dto.UserDtoConverter;
import com.exampleFinartz.demo.models.converter.entity.fromCreateRequest.UserCreateRequestToEntityConverter;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.UserEntity;
import com.exampleFinartz.demo.models.enums.Role;
import com.exampleFinartz.demo.models.request.create.UserCreateRequest;
import com.exampleFinartz.demo.repositories.UserRepository;
import com.exampleFinartz.demo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Integer ACCESS_TOKEN_MINUTE = 10;
    private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;
    private final UserDtoConverter userDtoConverter;
    private final UserCreateRequestToEntityConverter userCreateRequestToEntityConverter;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null)
            throw new UsernameNotFoundException("User not found in database");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userEntity.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        });
        return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }

    @Override
    public UserDTO getUser(Long id) {
        return userDtoConverter.convert(userRepository.getById(id));
    }

    @Override
    public UserDTO getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userDtoConverter.convert(userEntity);
    }

    @Override
    public UserDTO createUser(UserCreateRequest userCreateRequest) {
        //userCreateRequest.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        UserEntity userEntity = userCreateRequestToEntityConverter.convert(userCreateRequest);
        return userDtoConverter.convert(userRepository.save(userEntity));
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String email = decodedJWT.getSubject();
                UserDTO user = getUser(email);
                String accessToken = JWT.create()
                        .withSubject(user.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + ACCESS_TOKEN_MINUTE * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::name).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access-token", accessToken);
                tokens.put("refresh-token", refreshToken);

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_msg", exception.getMessage());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }

    }

}
