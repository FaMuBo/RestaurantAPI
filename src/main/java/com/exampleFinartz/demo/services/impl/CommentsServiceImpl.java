package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entities.Comments;
import com.exampleFinartz.demo.repositories.CommentsRepository;
import com.exampleFinartz.demo.services.CommentsService;

import java.util.List;

public class CommentsServiceImpl implements CommentsService {

    private CommentsRepository commentRepository;

    public CommentsServiceImpl(CommentsRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comments create(Comments comments) {
        Comments save = commentRepository.save(comments);
        return save;
    }

    @Override
    public List<Comments> getAll() {
        List<Comments> comments = commentRepository.findAll();
        return comments;
    }

    @Override
    public Comments getById(Long id) {
        Comments comments = commentRepository.getById(id);
        return comments;
    }

    @Override
    public Comments update(Comments comments) {
        Comments foundComments = commentRepository.getById(comments.getId());
        if (comments.getComment() != null) {
            foundComments.setComment(comments.getComment());
        }
        return commentRepository.save(comments);
    }

    @Override
    public Comments deleteById(Long id) {
        Comments comments = commentRepository.getById(id);
        if (comments != null) {
            commentRepository.deleteById(id);
            return comments;
        }
        return comments;
    }

    @Override
    public String delete(Long id) {
        commentRepository.deleteById(id);
        return "SUCCESS";
    }

}
