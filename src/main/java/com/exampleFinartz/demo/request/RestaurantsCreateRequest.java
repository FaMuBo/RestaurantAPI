package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.User;
import com.exampleFinartz.demo.enums.Position;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantsCreateRequest {
    private long id;
    private String name;
    private Position position;
    private User user;
    private List<Branch> branch;

}
