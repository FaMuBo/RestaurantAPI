package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.models.entity.BasketEntity;
import com.exampleFinartz.demo.repositories.BasketRepository;
import com.exampleFinartz.demo.services.BasketService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BasketEntityServiceTest {

    private static final double TOTAL_PRICE_116 = 116.0;
    private static final double TOTAL_PRICE_128 = 128.0;


    @InjectMocks
    private BasketService basketService;

    @Mock
    private BasketRepository basketRepository;


    @Test
    public void ReturnAllBasket() {
        BasketEntity basketEntity1 = BasketEntity.builder().id(1L).totalPrice(128.67).build();
        BasketEntity basketEntity2 = BasketEntity.builder().id(2L).totalPrice(116.16).build();
        List<BasketEntity> basketEntityList = Arrays.asList(basketEntity1, basketEntity2);

        Mockito.when(basketRepository.findAll()).thenReturn(basketEntityList);

        List<BasketEntity> fetchedList = basketService.getAll();

        assertEquals(basketEntityList.size(), fetchedList.size());
    }

    @Test
    public void ReturnBasketById() {
        BasketEntity basketEntity = BasketEntity.builder().totalPrice(128.67).build();

        Mockito.when(basketRepository.getById(1L)).thenReturn(basketEntity);

        BasketEntity fetchedBasketEntity = basketService.getById(1L);

        assertEquals(basketEntity.getId(), fetchedBasketEntity.getId());
    }

    @Test
    public void ReturnSavedBasket() {
        BasketEntity basketEntity = BasketEntity.builder().totalPrice(128.67).build();

        Mockito.doReturn(basketEntity).when(basketRepository).save(basketEntity);

        BasketEntity returnedBasketEntity = basketService.create(basketEntity);

        assertEquals(basketEntity.getTotalPrice(), returnedBasketEntity.getTotalPrice());
    }

    @Test
    public void ReturnUpdatedBasket() {
        BasketEntity existBasketEntity = BasketEntity.builder().id(1L).totalPrice(TOTAL_PRICE_116).build();
        BasketEntity newBasketEntity = BasketEntity.builder().id(1L).totalPrice(TOTAL_PRICE_128).build();

        Mockito.when(basketRepository.getById(1L)).thenReturn(existBasketEntity);

        Mockito.when(basketRepository.save(newBasketEntity)).thenReturn(newBasketEntity);

        BasketEntity updatedBasketEntity = basketService.update(newBasketEntity);

        Assertions.assertNotEquals(existBasketEntity.getTotalPrice(), TOTAL_PRICE_116);
        Assertions.assertEquals(existBasketEntity.getTotalPrice(), TOTAL_PRICE_128);

    }
}
