package com.fastcampus.restaurant.repository;

import java.util.List;

import com.fastcampus.restaurant.entity.MenuItem;

public interface MenuItemRepository {

    List<MenuItem> findAllByRestaurantId(Long RestaurantId);
}