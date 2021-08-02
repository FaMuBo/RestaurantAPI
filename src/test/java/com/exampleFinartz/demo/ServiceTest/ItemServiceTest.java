package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.entities.Item;
import com.exampleFinartz.demo.repositories.ItemRepository;
import com.exampleFinartz.demo.services.ItemService;
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
public class ItemServiceTest {

    private static final String InitStatus = "Pizza";
    private static final String NewStatus = "PizzaTost";

    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository itemRepository;

    @Test
    public void ReturnAllItem() {
        Item county1 = Item.builder().id(1l).name("Pizza").build();
        Item county2 = Item.builder().id(2l).name("PizzaTost").build();
        List<Item> commentList = Arrays.asList(county1, county2);
        Mockito.when(itemRepository.findAll()).thenReturn(commentList);
        List<Item> fetchedList = itemService.getAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnItemById() {
        Item item = Item.builder().name("Pizza").build();
        Mockito.when(itemRepository.getById(1L)).thenReturn(item);
        Item fetchedBasket = itemService.getById(1L);
        assertEquals(item.getId(), fetchedBasket.getId());
    }

    @Test
    public void ReturnSavedItem() {
        Item item = Item.builder().name("Pizza").build();
        Mockito.doReturn(item).when(itemRepository).save(item);
        Item returnedItem = itemService.create(item);
        assertEquals(item.getName(), returnedItem.getName());
    }

    @Test
    public void ReturnUpdatedItem() {
        Item existItem = Item.builder().id(1L).name(InitStatus).build();
        Item newItem = Item.builder().id(1L).name(NewStatus).build();

        Mockito.when(itemRepository.getById(1L)).thenReturn(existItem);
        Mockito.when(itemRepository.save(newItem)).thenReturn(newItem);

        Item updatedBasket = itemService.update(newItem);

        Assertions.assertEquals(existItem.getName(), NewStatus);
        Assertions.assertNotEquals(existItem.getName(), InitStatus);
    }
}

