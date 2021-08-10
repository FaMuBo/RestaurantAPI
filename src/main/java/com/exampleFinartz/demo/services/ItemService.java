package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.dto.ItemDTO;
import com.exampleFinartz.demo.models.request.create.ItemCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<ItemDTO> getItems(Integer pageNo, Integer pageSize, String sortBy);

//    ItemDTO getItem(Long id);

    ItemDTO createItem(ItemCreateRequest itemCreateRequest);

}
