package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entities.User;
import com.exampleFinartz.demo.repositories.UserRepository;
import com.exampleFinartz.demo.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User getById(Long id) {
        User user = userRepository.getById(id);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    //değiştirrrr 0 ı
    public User update(User user) {
        User foundUser = userRepository.getById(user.getId());
        if (user.getName() != null) {
            foundUser.setName(user.getName());
        }
        if (user.getPassword() != 0) {
            foundUser.setPassword(user.getPassword());
        }
        if (user.getEmail() != null) {
            foundUser.setEmail(user.getEmail());
        }
        if (user.getCardi̇nfo() != null) {
            foundUser.setCardi̇nfo(user.getCardi̇nfo());
        }
        if (user.getAdress() != null) {
            foundUser.setAdress(user.getAdress());
        }
        if (user.getComments() != null) {
            foundUser.setComments(user.getComments());
        }
        if (user.getRestaurants() != null) {
            foundUser.setRestaurants(user.getRestaurants());
        }
        return userRepository.save(user);
    }

    @Override
    public User deleteById(Long id) {
        User user = userRepository.getById(id);
        if (user != null) {
            userRepository.deleteById(id);
            return user;
        }
        return user;
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User getWaitingRestaurants() {
        return null;
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "SUCCESS";
    }
}
