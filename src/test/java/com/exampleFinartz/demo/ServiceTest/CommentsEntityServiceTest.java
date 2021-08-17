//package com.exampleFinartz.demo.ServiceTest;
//
//import com.exampleFinartz.demo.models.entity.CommentsEntity;
//import com.exampleFinartz.demo.repositories.CommentsRepository;
//import com.exampleFinartz.demo.services.CommentsService;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CommentsEntityServiceTest {
//
//    private static final String InitStatus = "Good!";
//    private static final String NewStatus = "Bad:(";
//
//    @InjectMocks
//    private CommentsService commentsService;
//    @Mock
//    private CommentsRepository commentsRepository;
//
//    @Test
//    public void ReturnAllComment() {
//        CommentsEntity comment1 = CommentsEntity.builder().id(1l).comment("It was good").build();
//        CommentsEntity comment2 = CommentsEntity.builder().id(2l).comment("Boo not good !!!").build();
//        List<CommentsEntity> commentList = Arrays.asList(comment1, comment2);
//        Mockito.when(commentsRepository.findAll()).thenReturn(commentList);
//        List<CommentsEntity> fetchedList = commentsService.getAll();
//        assertEquals(commentList.size(), fetchedList.size());
//    }
//
//    @Test
//    public void ReturnCommentById() {
//        CommentsEntity comment = CommentsEntity.builder().comment("It was good").build();
//        Mockito.when(commentsRepository.getById(1L)).thenReturn(comment);
//        CommentsEntity fetchedBasket = commentsService.getById(1L);
//        assertEquals(comment.getId(), fetchedBasket.getId());
//    }
//
//    @Test
//    public void ReturnSavedComment() {
//        CommentsEntity comment = CommentsEntity.builder().comment("Good").build();
//        Mockito.doReturn(comment).when(commentsRepository).save(comment);
//        CommentsEntity returnedComment = commentsService.create(comment);
//        assertEquals(comment.getComment(), returnedComment.getComment());
//    }
//
//    @Test
//    public void ReturnUpdatedComment() {
//        CommentsEntity existComment = CommentsEntity.builder().id(1L).comment(InitStatus).build();
//        CommentsEntity newComment = CommentsEntity.builder().id(1L).comment(NewStatus).build();
//
//        Mockito.when(commentsRepository.getById(1L)).thenReturn(existComment);
//        Mockito.when(commentsRepository.save(newComment)).thenReturn(newComment);
//
//        CommentsEntity updatedBasket = commentsService.update(newComment);
//        Assertions.assertNotEquals(existComment.getComment(), InitStatus);
//        Assertions.assertEquals(existComment.getComment(), NewStatus);
//    }
//}
