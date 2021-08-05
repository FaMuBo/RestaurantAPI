package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;

@Data
public class CommentsCreateRequest {
    private long id;
    private String comment;
    private int speed_point;
    private int taste_point;
    private User user;
    private Branch branch;

}
