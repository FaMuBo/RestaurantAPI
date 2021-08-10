package com.exampleFinartz.demo.models.dto;

import lombok.Data;

@Data
public class CommentsDTO {

    private long id;
    private String comment;
    private int speed_point;
    private int taste_point;
    private UserDTO user;
    private BranchDTO branch;
    private CommentsDTO comments;

//    public void setBranchEntity(BranchDTO convert) {
//    }
//
//    public void setUserEntity(UserDTO convert) {
//    }
}
