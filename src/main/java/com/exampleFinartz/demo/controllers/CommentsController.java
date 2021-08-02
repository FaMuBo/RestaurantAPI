package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.entities.Comments;
import com.exampleFinartz.demo.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;


    //        @PostMapping
//        public ResponseEntity<Comments> create(@RequestBody Comment comment, @RequestParam User user, @RequestParam Branch branch){
//            return new ResponseEntity<Comments>(commentsService.create(comment, user, branch), HttpStatus.CREATED);
//        }
    @PostMapping
    public ResponseEntity<Comments> create(@RequestBody Comments comments) {
        return new ResponseEntity(commentsService.create(comments), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Comments> update(@RequestBody Comment comment) {
        return new ResponseEntity<Comments>(commentsService.update((Comments) comment), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Comments> get(@PathVariable Long id) {
        return new ResponseEntity<Comments>(commentsService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Comments>> getAll() {
        return new ResponseEntity<>(commentsService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Comments> deleteById(@PathVariable Long id) {
        commentsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

