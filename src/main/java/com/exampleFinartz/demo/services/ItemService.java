package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    public Item create(Item ıtem);

    public List<Item> getAll();

    public Item getById(Long id);

    public Item update(Item ıtem);

    public Item deleteById(Long id);

    String delete(Long id);


}
