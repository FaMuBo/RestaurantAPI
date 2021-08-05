package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.entity.Comments;
import com.exampleFinartz.demo.repositories.CommentsRepository;
import com.exampleFinartz.demo.services.CommentsService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CommentsServiceTest {

    private static final String InitStatus = "Good!";
    private static final String NewStatus = "Bad:(";

    @InjectMocks
    private CommentsService commentsService;
    @Mock
    private CommentsRepository commentsRepository;

    @Test
    public void ReturnAllComment() {
        Comments comment1 = Comments.builder().id(1l).comment("It was good").build();
        Comments comment2 = Comments.builder().id(2l).comment("Boo not good !!!").build();
        List<Comments> commentList = Arrays.asList(comment1, comment2);
        Mockito.when(commentsRepository.findAll()).thenReturn(commentList);
        List<Comments> fetchedList = commentsService.getAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnCommentById() {
        Comments comment = Comments.builder().comment("It was good").build();
        Mockito.when(commentsRepository.getById(1L)).thenReturn(comment);
        Comments fetchedBasket = commentsService.getById(1L);
        assertEquals(comment.getId(), fetchedBasket.getId());
    }

    @Test
    public void ReturnSavedComment() {
        Comments comment = Comments.builder().comment("Good").build();
        Mockito.doReturn(comment).when(commentsRepository).save(comment);
        Comments returnedComment = commentsService.create(comment);
        assertEquals(comment.getComment(), returnedComment.getComment());
    }

    @Test
    public void ReturnUpdatedComment() {
        Comments existComment = Comments.builder().id(1L).comment(InitStatus).build();
        Comments newComment = Comments.builder().id(1L).comment(NewStatus).build();

        Mockito.when(commentsRepository.getById(1L)).thenReturn(existComment);
        Mockito.when(commentsRepository.save(newComment)).thenReturn(newComment);

        Comments updatedBasket = commentsService.update(newComment);
        Assertions.assertNotEquals(existComment.getComment(), InitStatus);
        Assertions.assertEquals(existComment.getComment(), NewStatus);
    }
}
