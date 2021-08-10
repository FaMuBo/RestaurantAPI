package com.exampleFinartz.demo.models.dto;

import com.exampleFinartz.demo.models.enums.Position;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantsDTO {
    private long id;
    private String name;
    private Position position;
    private UserDTO user;
    private List<BranchDTO> branch;

//    public void setUserEntity(UserDTO convert) {
//    }
}
