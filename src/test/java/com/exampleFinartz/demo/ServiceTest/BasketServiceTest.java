package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.entities.Basket;
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
public class BasketServiceTest {

    private static final double TOTAL_PRICE_116 = 116.0;
    private static final double TOTAL_PRICE_128 = 128.0;


    @InjectMocks
    private BasketService basketService;

    @Mock
    private BasketRepository basketRepository;


    @Test
    public void ReturnAllBasket() {
        Basket basket1 = Basket.builder().id(1L).totalPrice(128.67).build();
        Basket basket2 = Basket.builder().id(2L).totalPrice(116.16).build();
        List<Basket> basketList = Arrays.asList(basket1, basket2);

        Mockito.when(basketRepository.findAll()).thenReturn(basketList);

        List<Basket> fetchedList = basketService.getAll();

        assertEquals(basketList.size(), fetchedList.size());
    }

    @Test
    public void ReturnBasketById() {
        Basket basket = Basket.builder().totalPrice(128.67).build();

        Mockito.when(basketRepository.getById(1L)).thenReturn(basket);

        Basket fetchedBasket = basketService.getById(1L);

        assertEquals(basket.getId(), fetchedBasket.getId());
    }

    @Test
    public void ReturnSavedBasket() {
        Basket basket = Basket.builder().totalPrice(128.67).build();

        Mockito.doReturn(basket).when(basketRepository).save(basket);

        Basket returnedBasket = basketService.create(basket);

        assertEquals(basket.getTotalPrice(), returnedBasket.getTotalPrice());
    }

    @Test
    public void ReturnUpdatedBasket() {
        Basket existBasket = Basket.builder().id(1L).totalPrice(TOTAL_PRICE_116).build();
        Basket newBasket = Basket.builder().id(1L).totalPrice(TOTAL_PRICE_128).build();

        Mockito.when(basketRepository.getById(1L)).thenReturn(existBasket);

        Mockito.when(basketRepository.save(newBasket)).thenReturn(newBasket);

        Basket updatedBasket = basketService.update(newBasket);

        Assertions.assertNotEquals(existBasket.getTotalPrice(), TOTAL_PRICE_116);
        Assertions.assertEquals(existBasket.getTotalPrice(), TOTAL_PRICE_128);

    }


}
