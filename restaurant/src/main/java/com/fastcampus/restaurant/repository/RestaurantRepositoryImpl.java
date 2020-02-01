package com.fastcampus.restaurant.repository;

import java.util.ArrayList;
import java.util.List;

import com.fastcampus.restaurant.entity.Restaurant;

public class RestaurantRepositoryImpl implements RestaurantRepository{

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepositoryImpl(){
        restaurants.add(new Restaurant(1004L,"Bob zip","Seoul"));
        restaurants.add(new Restaurant(1004L,"Bob zip","Seoul"));
    }

    public List<Restaurant> findAll(){
        return restaurants;
    }

    public Restaurant findById(Long id){
        return restaurants.stream().filter(r -> r.getId().equals(id))
                                    .findFirst().orElse(null);
    }
}