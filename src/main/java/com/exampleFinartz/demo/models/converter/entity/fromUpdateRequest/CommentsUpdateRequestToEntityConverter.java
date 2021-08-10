package com.exampleFinartz.demo.models.converter.entity.fromUpdateRequest;

import com.exampleFinartz.demo.models.entity.CommentsEntity;
import com.exampleFinartz.demo.models.request.update.CommentsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentUpdateRequestToEntityConverter {

    public CommentsEntity convert(final CommentsUpdateRequest commentsUpdateRequest,
                                  final CommentsEntity commentsExisted) {
        if (commentsUpdateRequest == null)
            return null;

        if (commentsUpdateRequest.getComment() != null)
            commentsExisted.setComment(commentsUpdateRequest.getComment());

        if (commentsUpdateRequest.getSpeed_point() != 0)
            commentsExisted.setTaste_point(commentsUpdateRequest.getTaste_point());

        if (commentsUpdateRequest.getTaste_point() != 0)
            commentsExisted.setSpeed_point(commentsUpdateRequest.getTaste_point());

        return commentsExisted;
    }


}