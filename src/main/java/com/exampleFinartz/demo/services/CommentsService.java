package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.dto.CommentsDTO;
import com.exampleFinartz.demo.models.request.create.CommentsCreateRequest;
import com.exampleFinartz.demo.models.request.update.CommentsUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public interface CommentsService {

    CommentsDTO getComments(Long id);

    CommentsDTO createComments(CommentsCreateRequest commentCreateRequest);

    CommentsDTO updateComments(Long id, CommentsUpdateRequest commentUpdateRequest);

    void deleteComments(Long id);


}
