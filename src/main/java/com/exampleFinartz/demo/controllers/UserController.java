package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.request.create.UserCreateRequest;
import com.exampleFinartz.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

;

@RestController
@RequestMapping("user")
public class UserController {

    private final Integer ACCESS_TOKEN_MINUTE = 10;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        return new ResponseEntity(userService.createUser(userCreateRequest), HttpStatus.CREATED);
    }

    @GetMapping("refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.refreshToken(request, response);
    }

}