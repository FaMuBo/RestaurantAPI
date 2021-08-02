package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.User;
import com.exampleFinartz.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User getById(Long id) {
        User user = userRepository.getById(id);
        return user;
    }

    public User getByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

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

    public User deleteById(Long id) {
        User user = userRepository.getById(id);
        if (user != null) {
            userRepository.deleteById(id);
            return user;
        }
        return user;
    }

    public String delete(long id) {
        userRepository.deleteById(id);
        return "SUCCESS";
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public Object getWaitingRestaurants() {
        return null;
    }
}
