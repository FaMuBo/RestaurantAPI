package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.CommentsDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.CommentsEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommentsDtoConverter implements GenericConverter<CommentsEntity, CommentsDTO> {

    private final GenericConverter<BranchEntity, BranchDTO> branchDtoConverter;
    private final GenericConverter<UserEntity, UserDTO> usersDtoConverter;

    @Override
    public CommentsDTO convert(final CommentsEntity commentsEntity) {
        if (commentsEntity == null) {
            return null;
        }


        CommentsDTO commentDto = new CommentsDTO();

        commentDto.setId(commentsEntity.getId());
        commentDto.setComment(commentsEntity.getComment());
        commentDto.setSpeed_point(commentsEntity.getSpeed_point());
        commentDto.setTaste_point(commentsEntity.getTaste_point());
        commentDto.setUser(convert(commentsEntity.getUserEntity()));
        commentDto.setBranch(convert(commentsEntity.getBranchEntity()));

        return commentDto;

    }


    private BranchDTO convert(final BranchEntity branchEntity) {
        return branchDtoConverter.convert(branchEntity);
    }

    private UserDTO convert(final UserEntity userEntity) {
        return usersDtoConverter.convert(userEntity);
    }


}