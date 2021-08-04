package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
//extends UserDetailsService {

    //   @Override
    // public UserDetails loadUserByUsername(String email);

    public User create(User user);

    public List<User> getAll();

    public User getById(Long id);

    public User findByEmail(String email);

    public User update(User user);

    public User deleteById(Long id);

    public User getWaitingRestaurants();

    public User getUserByName(String name);

    String delete(Long id);


}