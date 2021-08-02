package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Item;
import com.exampleFinartz.demo.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item create(Item item) {
        Item save = itemRepository.save(item);
        return save;
    }

    public List<Item> getAll() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    public Item getById(Long id) {
        Item item = itemRepository.getById(id);
        return item;
    }

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

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

    public String delete(long id) {
        itemRepository.deleteById(id);
        return "SUCCESS";
    }
}
