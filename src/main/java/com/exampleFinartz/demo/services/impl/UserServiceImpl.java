package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.UserDtoConverter;
import com.exampleFinartz.demo.models.converter.entity.fromCreateRequest.UserCreateRequestToEntityConverter;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.UserEntity;
import com.exampleFinartz.demo.models.request.create.UserCreateRequest;
import com.exampleFinartz.demo.repositories.UserRepository;
import com.exampleFinartz.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;
    private final UserDtoConverter userDtoConverter;
    private final UserCreateRequestToEntityConverter userCreateRequestToEntityConverter;

//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepository.findByEmail(email);
//        if(userEntity == null)
//            throw new UsernameNotFoundException("User not found in database");
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        userEntity.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority(role.toString()));
//        });
//        return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPassword(), authorities);
//  }

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

}
