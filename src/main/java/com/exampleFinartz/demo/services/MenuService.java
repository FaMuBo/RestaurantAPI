package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {

    public Menu create(Menu menu);

    public List<Menu> getAll();

    public Menu getById(Long id);

    public Menu update(Menu menu);

    public Menu deleteById(Long id);

    String delete(Long id);
}
