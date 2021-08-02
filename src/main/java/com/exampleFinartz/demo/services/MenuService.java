package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Menu;
import com.exampleFinartz.demo.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu create(Menu menu) {
        Menu save = menuRepository.save(menu);
        return save;
    }

    public List<Menu> getAll() {
        List<Menu> menus = menuRepository.findAll();
        return menus;
    }

    public Menu getById(Long id) {
        Menu menu = menuRepository.getById(id);
        return menu;
    }

    // UPDATEYİ AYARLA
    public Menu update(Menu menu) {
        Menu foundMenu = menuRepository.getById(menu.getId());
        if (menu.getBranch() != null) {
            foundMenu.setBranch(menu.getBranch());
        }
        if (menu.getMeal() != null) {
            foundMenu.setMeal(menu.getMeal());
        }
        if (menu.getMeallistt() != null) {
            foundMenu.setMeallistt(menu.getMeallistt());
        }

        return menuRepository.save(menu);
    }

    public Menu deleteById(Long id) {
        Menu menu = menuRepository.getById(id);
        if (menu != null) {
            menuRepository.deleteById(id);
            return menu;
        }
        return menu;
    }

    public String delete(long id) {
        menuRepository.deleteById(id);
        return "SUCCESS";
    }
}
