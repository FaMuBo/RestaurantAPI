package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentsService {
    public Comments create(Comments comments);

    public List<Comments> getAll();

    public Comments getById(Long id);

    public Comments update(Comments comments);

    public Comments deleteById(Long id);

    String delete(Long id);


}
