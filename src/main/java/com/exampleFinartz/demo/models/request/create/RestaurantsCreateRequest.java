package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.enums.Position;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantsCreateRequest {
    private long id;
    private String name;
    private Position position;
    private UserDTO user;
    private List<BranchDTO> branchDTOList;

}
