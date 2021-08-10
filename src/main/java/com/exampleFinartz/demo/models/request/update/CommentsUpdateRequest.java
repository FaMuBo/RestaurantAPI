package com.exampleFinartz.demo.models.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentsUpdateRequest {


    private String comment;

    private int taste_point;

    private int speed_point;
}
