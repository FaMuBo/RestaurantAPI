package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;

@Data
public class CommentsDTO {

    private long id;
    private String comment;
    private int speed_point;
    private int taste_point;
    private User user;
    private Branch branch;

    public void setBranch(BranchDTO convert) {
    }

    public void setUser(UserDTO convert) {
    }
}
