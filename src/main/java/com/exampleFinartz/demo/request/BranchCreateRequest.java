package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.Address;
import com.exampleFinartz.demo.entity.Comments;
import com.exampleFinartz.demo.entity.Menu;
import com.exampleFinartz.demo.entity.Restaurants;
import com.exampleFinartz.demo.enums.Position;
import com.exampleFinartz.demo.enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class BranchCreateRequest {

    private long id;
    private String name;
    private Role role;
    private Position position;
    private int speed_rate;
    private int taste_rate;
    private int comment_count;
    private int vote_rate;
    private Menu menu;
    private List<Comments> comments;
    private Restaurants restaurants;
    private Address address;
}

