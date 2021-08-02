package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Comments;
import com.exampleFinartz.demo.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private CommentsRepository commentRepository;

    public Comments create(Comments comments) {
        Comments save = commentRepository.save(comments);
        return save;
    }

    public List<Comments> getAll() {
        List<Comments> comments = commentRepository.findAll();
        return comments;
    }

    public Comments getById(Long id) {
        Comments comments = commentRepository.getById(id);
        return comments;
    }

    public Comments update(Comments comments) {
        Comments foundComments = commentRepository.getById(comments.getId());
        if (comments.getComment() != null) {
            foundComments.setComment(comments.getComment());
        }
        return commentRepository.save(comments);
    }

    public Comments deleteById(Long id) {
        Comments comments = commentRepository.getById(id);
        if (comments != null) {
            commentRepository.deleteById(id);
            return comments;
        }
        return comments;
    }

    public String delete(long id) {
        commentRepository.deleteById(id);
        return "SUCCESS";
    }

}
