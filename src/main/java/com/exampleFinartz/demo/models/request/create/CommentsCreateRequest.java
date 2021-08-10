package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import lombok.Data;

@Data
public class CommentsCreateRequest {
    private long id;
    private String comment;
    private int speed_point;
    private int taste_point;
    private UserDTO user;
    private BranchDTO branch;

}
