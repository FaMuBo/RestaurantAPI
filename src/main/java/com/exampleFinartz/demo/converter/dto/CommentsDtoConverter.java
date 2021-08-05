package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.BranchDTO;
import com.exampleFinartz.demo.dto.CommentsDTO;
import com.exampleFinartz.demo.dto.UserDTO;
import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.Comments;
import com.exampleFinartz.demo.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommentsDtoConverter implements GenericConverter<Comments, CommentsDTO> {

    private final GenericConverter<Branch, BranchDTO> branchDtoConverter;
    private final GenericConverter<User, UserDTO> usersDtoConverter;

    @Override
    public CommentsDTO convert(final Comments comments) {
        if (comments == null) {
            return null;
        }

        CommentsDTO comments1 = new CommentsDTO();

        comments1.setId(comments1.getId());
        comments1.setBranch(convert(comments1.getBranch()));
        comments1.setUser(convert(comments1.getUser()));
        comments1.setComment(comments1.getComment());
        comments1.setTaste_point(comments1.getTaste_point());
        comments1.setSpeed_point(comments1.getSpeed_point());


        return comments1;

    }


    private BranchDTO convert(final Branch branch) {
        return branchDtoConverter.convert(branch);
    }

    private UserDTO convert(final User user) {
        return usersDtoConverter.convert(user);
    }


}