package com.exampleFinartz.demo.models.converter.entity.fromDTO;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.CommentsDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.CommentsEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentsDtoToEntityConverter implements GenericConverter<CommentsDTO, CommentsEntity> {

    private final GenericConverter<UserDTO, UserEntity> userEntityConverter;
    private final GenericConverter<BranchDTO, BranchEntity> branchEntityConverter;

    @Override
    public CommentsEntity convert(final CommentsDTO comment) {
        if (comment == null) {
            return null;
        }

        CommentsEntity commentEntity = new CommentsEntity();

        commentEntity.setId(comment.getId());
        commentEntity.setComment(comment.getComment());
        commentEntity.setSpeed_point(comment.getSpeed_point());
        commentEntity.setTaste_point(comment.getTaste_point());
        commentEntity.setUserEntity(convert(comment.getUser()));
        commentEntity.setBranchEntity(convert(comment.getBranch()));

        return commentEntity;
    }

    private UserEntity convert(final UserDTO user) {
        return userEntityConverter.convert(user);
    }

    private BranchEntity convert(final BranchDTO branch) {
        return branchEntityConverter.convert(branch);
    }

}