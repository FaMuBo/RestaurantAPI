package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.dto.CommentsDTO;
import com.exampleFinartz.demo.models.request.create.CommentsCreateRequest;
import com.exampleFinartz.demo.models.request.update.CommentsUpdateRequest;
import com.exampleFinartz.demo.services.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CommentsDTO> getComments(@PathVariable Long id) {
        return new ResponseEntity(commentsService.getComments(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentsDTO> createComments(@RequestBody CommentsCreateRequest commentsCreateRequest) {
        return new ResponseEntity(commentsService.createComments(commentsCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CommentsDTO> updateComments(@PathVariable Long id, @RequestBody CommentsUpdateRequest commentsUpdateRequest) {
        return new ResponseEntity(commentsService.updateComments(id, commentsUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteComments(@PathVariable Long id) throws Exception {
        commentsService.deleteComments(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}