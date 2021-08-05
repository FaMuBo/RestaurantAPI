package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.BasketDTO;
import com.exampleFinartz.demo.dto.OrdersDTO;
import com.exampleFinartz.demo.entity.Basket;
import com.exampleFinartz.demo.entity.Orders;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrdersDtoConverter implements GenericConverter<Orders, OrdersDTO> {

    private final GenericConverter<Basket, BasketDTO> basketDtoConverter;

    @Override
    public OrdersDTO convert(final Orders orders) {
        if (orders == null) {
            return null;
        }

        OrdersDTO order1 = new OrdersDTO();

        order1.setId(order1.getId());
        order1.setAmount(order1.getAmount());
        order1.setDate(order1.getDate());
        order1.setBasket(convert(order1.getBasket()));

        return order1;

    }

    private BasketDTO convert(final Basket basket) {
        return basketDtoConverter.convert(basket);
    }


}