package com.exampleFinartz.demo.models.converter.entity.fromCreateRequest;


import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.CommentsEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import com.exampleFinartz.demo.models.request.create.CommentsCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentsCreateRequestToEntityConverter implements GenericConverter<CommentsCreateRequest, CommentsEntity> {

    private final GenericConverter<UserDTO, UserEntity> userEntityConverter;
    private final GenericConverter<BranchDTO, BranchEntity> branchEntityConverter;

    @Override
    public CommentsEntity convert(final CommentsCreateRequest commentCreateRequest) {
        if (commentCreateRequest == null) {
            return null;
        }

        CommentsEntity commentsEntity = new CommentsEntity();

        commentsEntity.setComment(commentCreateRequest.getComment());
        commentsEntity.setSpeed_point(commentCreateRequest.getSpeed_point());
        commentsEntity.setTaste_point(commentCreateRequest.getTaste_point());
        commentsEntity.setUserEntity(convert(commentCreateRequest.getUser()));
        commentsEntity.setBranchEntity(convert(commentCreateRequest.getBranch()));

        return commentsEntity;
    }

    private UserEntity convert(final UserDTO user) {
        return userEntityConverter.convert(user);
    }

    private BranchEntity convert(final BranchDTO branch) {
        return branchEntityConverter.convert(branch);
    }

}
