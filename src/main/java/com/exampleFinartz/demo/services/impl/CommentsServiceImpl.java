package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.CommentsDtoConverter;
import com.exampleFinartz.demo.models.converter.entity.fromCreateRequest.CommentsCreateRequestToEntityConverter;
import com.exampleFinartz.demo.models.converter.entity.fromUpdateRequest.CommentUpdateRequestToEntityConverter;
import com.exampleFinartz.demo.models.dto.CommentsDTO;
import com.exampleFinartz.demo.models.entity.CommentsEntity;
import com.exampleFinartz.demo.models.request.create.CommentsCreateRequest;
import com.exampleFinartz.demo.models.request.update.CommentsUpdateRequest;
import com.exampleFinartz.demo.repositories.CommentsRepository;
import com.exampleFinartz.demo.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;
    private final CommentsDtoConverter commentsDtoConverter;
    private final CommentsCreateRequestToEntityConverter commentsCreateRequestToEntityConverter;
    private final CommentUpdateRequestToEntityConverter commentsUpdateRequestToEntityConverter;


    @Override
    public CommentsDTO getComments(Long id) {
        CommentsEntity commentsEntity = commentsRepository.getById(id);
        return commentsDtoConverter.convert(commentsEntity);
    }

    @Override
    public CommentsDTO createComments(CommentsCreateRequest commentsCreateRequest) {
        CommentsEntity commentsEntity = commentsCreateRequestToEntityConverter.convert(commentsCreateRequest);
        return commentsDtoConverter.convert(commentsRepository.save(commentsEntity));
    }

    @Override
    public CommentsDTO updateComments(Long id, CommentsUpdateRequest commentsUpdateRequest) {
        CommentsEntity commentsExisted = commentsRepository.getById(id);

        CommentsEntity commentsUpdated =
                commentsUpdateRequestToEntityConverter.convert(commentsUpdateRequest, commentsExisted);

        return commentsDtoConverter.convert(commentsRepository.save(commentsUpdated));

    }

    @Override
    public void deleteComments(Long id) {
        commentsRepository.deleteById(id);
    }
}