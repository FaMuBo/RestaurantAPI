package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.User;
import com.exampleFinartz.demo.enums.Position;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantsDTO {
    private long id;
    private String name;
    private Position position;
    private User user;
    private List<Branch> branch;

    public void setUser(UserDTO convert) {
    }
}
