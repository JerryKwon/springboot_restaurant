package com.fastcampus.restaurant.repository;

import java.util.ArrayList;
import java.util.List;

import com.fastcampus.restaurant.entity.MenuItem;

public class MenuItemRepositoryImpl implements MenuItemRepository {

    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuItemRepositoryImpl(){
        menuItems.add(new MenuItem("Kimchi"));
    }

    @Override
    public List<MenuItem> findAllByRestaurantId(Long id) {
        // TODO Auto-generated method stub
        return menuItems;
    }

}