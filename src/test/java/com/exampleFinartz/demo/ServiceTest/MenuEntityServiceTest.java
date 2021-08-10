package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.models.entity.MenuEntity;
import com.exampleFinartz.demo.repositories.MenuRepository;
import com.exampleFinartz.demo.services.MenuService;
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
public class MenuEntityServiceTest {

    private static final int InitStatus = 115;
    private static final int NewStatus = 120;
    @InjectMocks
    private MenuService menuService;
    @Mock
    private MenuRepository menuRepository;

    @Test
    public void ReturnAllMenu() {

        MenuEntity county1 = MenuEntity.builder().id(1l).item_count(115).build();
        MenuEntity county2 = MenuEntity.builder().id(2l).item_count(120).build();
        List<MenuEntity> commentList = Arrays.asList(county1, county2);
        Mockito.when(menuRepository.findAll()).thenReturn(commentList);
        List<MenuEntity> fetchedList = menuService.getAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnMenuById() {
        MenuEntity menuEntity = MenuEntity.builder().item_count(115).build();
        Mockito.when(menuRepository.getById(1L)).thenReturn(menuEntity);
        MenuEntity fetchedMenuEntity = menuService.getById(1L);
        assertEquals(menuEntity.getId(), fetchedMenuEntity.getId());
    }

    @Test
    public void ReturnSavedMenu() {
        MenuEntity menuEntity = MenuEntity.builder().item_count(500).build();
        Mockito.doReturn(menuEntity).when(menuRepository).save(menuEntity);
        MenuEntity returnedMenuEntity = menuService.create(menuEntity);
        assertEquals(menuEntity.getItem_count(), returnedMenuEntity.getItem_count());
    }

    @Test
    public void ReturnUpdatedMenu() {
        MenuEntity existMenuEntity = MenuEntity.builder().id(1L).item_count(InitStatus).build();
        MenuEntity newMenuEntity = MenuEntity.builder().id(1L).item_count(NewStatus).build();

        Mockito.when(menuRepository.getById(1L)).thenReturn(existMenuEntity);
        Mockito.when(menuRepository.save(newMenuEntity)).thenReturn(newMenuEntity);

        MenuEntity updatedMenuEntity = menuService.update(newMenuEntity);

        Assertions.assertEquals(existMenuEntity.getItem_count(), InitStatus);
        Assertions.assertNotEquals(existMenuEntity.getItem_count(), NewStatus);
    }
}

