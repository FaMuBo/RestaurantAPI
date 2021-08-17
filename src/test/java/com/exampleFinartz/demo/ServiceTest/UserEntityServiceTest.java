//package com.exampleFinartz.demo.ServiceTest;
//
//
//import com.exampleFinartz.demo.models.entity.UserEntity;
//import com.exampleFinartz.demo.models.enums.Role;
//import com.exampleFinartz.demo.repositories.UserRepository;
//import com.exampleFinartz.demo.services.UserService;
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
//public class UserEntityServiceTest {
//    private static final Role InitStatus = Role.SELLER;
//    private static final Role NewStatus = Role.ADMIN;
//    @InjectMocks
//    private UserService userService;
//    @Mock
//    private UserRepository userRepository;
//
//    @Test
//    public void ReturnAllUser() {
//        UserEntity userEntity1 = UserEntity.builder().id(1l).role(Role.SELLER).build();
//        UserEntity userEntity2 = UserEntity.builder().id(2l).role(Role.ADMIN).build();
//        List<UserEntity> commentList = Arrays.asList(userEntity1, userEntity2);
//        Mockito.when(userRepository.findAll()).thenReturn(commentList);
//        List<UserEntity> fetchedList = userService.getAll();
//        assertEquals(commentList.size(), fetchedList.size());
//    }
//
//    @Test
//    public void ReturnUserById() {
//        UserEntity userEntity = UserEntity.builder().role(Role.SELLER).build();
//        Mockito.when(userRepository.getById(1L)).thenReturn(userEntity);
//        UserEntity fetchedUserEntity = userService.getById(1L);
//        assertEquals(userEntity.getId(), fetchedUserEntity.getId());
//    }
//
//    @Test
//    public void ReturnSavedUser() {
//        UserEntity userEntity = UserEntity.builder().role(Role.ADMIN).build();
//        Mockito.doReturn(userEntity).when(userRepository).save(userEntity);
//        UserEntity returnedUserEntity = userService.create(userEntity);
//        assertEquals(userEntity.getRole(), returnedUserEntity.getRole());
//    }
//
//    @Test
//    public void ReturnUpdatedUser() {
//        UserEntity existUserEntity = UserEntity.builder().id(1L).role(InitStatus).build();
//        UserEntity newUserEntity = UserEntity.builder().id(1L).role(NewStatus).build();
//
//        Mockito.when(userRepository.getById(1L)).thenReturn(existUserEntity);
//        Mockito.when(userRepository.save(newUserEntity)).thenReturn(newUserEntity);
//
//        UserEntity updatedUserEntity = userService.update(newUserEntity);
//
//        Assertions.assertEquals(existUserEntity.getRole(), InitStatus);
//        Assertions.assertNotEquals(existUserEntity.getRole(), NewStatus);
//    }
//}
//
