package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.ItemDtoConverter;
import com.exampleFinartz.demo.models.converter.entity.fromCreateRequest.ItemCreateRequestToEntityConverter;
import com.exampleFinartz.demo.models.dto.ItemDTO;
import com.exampleFinartz.demo.models.entity.ItemEntity;
import com.exampleFinartz.demo.models.request.create.ItemCreateRequest;
import com.exampleFinartz.demo.repositories.ItemRepository;
import com.exampleFinartz.demo.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemDtoConverter itemDtoConverter;
    private final ItemCreateRequestToEntityConverter itemCreateRequestToEntityConverter;

    @Override
    public List<ItemDTO> getItems(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<ItemEntity> itemEntityPage = itemRepository.findAll(paging);
        List<ItemDTO> items = new ArrayList<>();
        itemEntityPage.forEach(itemEntity -> {
            items.add(itemDtoConverter.convert(itemEntity));
        });
        return items;
    }

//    @Override
//    public ItemDTO getItem(Long id){
//        return itemDtoConverter.convert(itemRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Not found Item with id: " + id)
//        ));
//    }

    @Override
    public ItemDTO createItem(ItemCreateRequest itemCreateRequest) {
        ItemEntity itemEntity = itemCreateRequestToEntityConverter.convert(itemCreateRequest);
        return itemDtoConverter.convert(itemRepository.save(itemEntity));
    }

}
