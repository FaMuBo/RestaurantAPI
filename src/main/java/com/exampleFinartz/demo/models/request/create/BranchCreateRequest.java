package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.AddressDTO;
import com.exampleFinartz.demo.models.dto.CommentsDTO;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.enums.Position;
import com.exampleFinartz.demo.models.enums.Role;
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
    private MenuDTO menu;
    private List<CommentsDTO> commentsDTOList;
    private RestaurantsDTO restaurants;
    private AddressDTO address;
}

