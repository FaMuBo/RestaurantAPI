//package com.exampleFinartz.demo.ServiceTest;
//
//import com.exampleFinartz.demo.models.entity.ItemEntity;
//import com.exampleFinartz.demo.repositories.ItemRepository;
//import com.exampleFinartz.demo.services.ItemService;
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
//public class ItemEntityServiceTest {
//
//    private static final String InitStatus = "Pizza";
//    private static final String NewStatus = "PizzaTost";
//
//    @InjectMocks
//    private ItemService itemService;
//    @Mock
//    private ItemRepository itemRepository;
//
//    @Test
//    public void ReturnAllItem() {
//        ItemEntity county1 = ItemEntity.builder().id(1l).name("Pizza").build();
//        ItemEntity county2 = ItemEntity.builder().id(2l).name("PizzaTost").build();
//        List<ItemEntity> commentList = Arrays.asList(county1, county2);
//        Mockito.when(itemRepository.findAll()).thenReturn(commentList);
//        List<ItemEntity> fetchedList = itemService.getAll();
//        assertEquals(commentList.size(), fetchedList.size());
//    }
//
//    @Test
//    public void ReturnItemById() {
//        ItemEntity itemEntity = ItemEntity.builder().name("Pizza").build();
//        Mockito.when(itemRepository.getById(1L)).thenReturn(itemEntity);
//        ItemEntity fetchedBasket = itemService.getById(1L);
//        assertEquals(itemEntity.getId(), fetchedBasket.getId());
//    }
//
//    @Test
//    public void ReturnSavedItem() {
//        ItemEntity itemEntity = ItemEntity.builder().name("Pizza").build();
//        Mockito.doReturn(itemEntity).when(itemRepository).save(itemEntity);
//        ItemEntity returnedItemEntity = itemService.create(itemEntity);
//        assertEquals(itemEntity.getName(), returnedItemEntity.getName());
//    }
//
//    @Test
//    public void ReturnUpdatedItem() {
//        ItemEntity existItemEntity = ItemEntity.builder().id(1L).name(InitStatus).build();
//        ItemEntity newItemEntity = ItemEntity.builder().id(1L).name(NewStatus).build();
//
//        Mockito.when(itemRepository.getById(1L)).thenReturn(existItemEntity);
//        Mockito.when(itemRepository.save(newItemEntity)).thenReturn(newItemEntity);
//
//        ItemEntity updatedBasket = itemService.update(newItemEntity);
//
//        Assertions.assertEquals(existItemEntity.getName(), NewStatus);
//        Assertions.assertNotEquals(existItemEntity.getName(), InitStatus);
//    }
//}
//
