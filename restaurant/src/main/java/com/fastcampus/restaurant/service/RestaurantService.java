package com.fastcampus.restaurant.service;

import java.util.List;

import com.fastcampus.restaurant.entity.MenuItem;
import com.fastcampus.restaurant.entity.Restaurant;
import com.fastcampus.restaurant.repository.MenuItemRepository;
import com.fastcampus.restaurant.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant getRestaurant(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(restaurantId);

        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }

}