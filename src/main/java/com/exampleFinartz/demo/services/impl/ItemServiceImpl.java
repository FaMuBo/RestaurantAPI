package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entities.Item;
import com.exampleFinartz.demo.repositories.ItemRepository;
import com.exampleFinartz.demo.services.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {


    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(Item item) {
        Item save = itemRepository.save(item);
        return save;
    }

    @Override
    public List<Item> getAll() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    @Override
    public Item getById(Long id) {
        Item item = itemRepository.getById(id);
        return item;
    }

    @Override
    public Item update(Item item) {
        Item foundItem = itemRepository.getById(item.getId());
        if (item.getName() != null) {
            foundItem.setName(item.getName());
        }
        if (item.getMealList() != null) {
            foundItem.setMealList(item.getMealList());
        }
        return itemRepository.save(item);
    }

    @Override
    public Item deleteById(Long id) {
        Item ıtem = itemRepository.getById(id);
        if (ıtem != null) {
            itemRepository.deleteById(id);
            return ıtem;
        }
        return ıtem;
    }

    @Override
    public String delete(Long id) {
        itemRepository.deleteById(id);
        return "SUCCESS";
    }

}
