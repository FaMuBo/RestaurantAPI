package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BasketDTO;
import com.exampleFinartz.demo.models.dto.OrdersDTO;
import com.exampleFinartz.demo.models.entity.BasketEntity;
import com.exampleFinartz.demo.models.entity.OrdersEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrdersDtoConverter implements GenericConverter<OrdersEntity, OrdersDTO> {

    private final GenericConverter<BasketEntity, BasketDTO> basketDtoConverter;

    @Override
    public OrdersDTO convert(final OrdersEntity ordersEntity) {
        if (ordersEntity == null) {
            return null;
        }

        OrdersDTO order1 = new OrdersDTO();

        order1.setId(order1.getId());
        order1.setAmount(order1.getAmount());
        order1.setDate(order1.getDate());
        order1.setBasket(convert(ordersEntity.getBasketEntity()));

        return order1;

    }

    private BasketDTO convert(final BasketEntity basketEntity) {
        return basketDtoConverter.convert(basketEntity);
    }


}