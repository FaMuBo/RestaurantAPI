package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entity.Menu;
import com.exampleFinartz.demo.repositories.MenuRepository;
import com.exampleFinartz.demo.services.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu create(Menu menu) {
        Menu save = menuRepository.save(menu);
        return save;
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> menus = menuRepository.findAll();
        return menus;
    }

    @Override
    public Menu getById(Long id) {
        Menu menu = menuRepository.getById(id);
        return menu;
    }

    @Override
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

    @Override
    public Menu deleteById(Long id) {
        Menu menu = menuRepository.getById(id);
        if (menu != null) {
            menuRepository.deleteById(id);
            return menu;
        }
        return menu;
    }

    @Override
    public String delete(Long id) {
        menuRepository.deleteById(id);
        return "SUCCESS";
    }
}
