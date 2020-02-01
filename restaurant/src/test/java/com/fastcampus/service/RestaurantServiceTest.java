package com.fastcampus.service;

import static org.junit.Assert.assertThat;

import java.util.List;

import com.fastcampus.restaurant.entity.MenuItem;
import com.fastcampus.restaurant.entity.Restaurant;
import com.fastcampus.restaurant.repository.MenuItemRepository;
import com.fastcampus.restaurant.repository.RestaurantRepository;
import com.fastcampus.restaurant.repository.RestaurantRepositoryImpl;
import com.fastcampus.restaurant.service.RestaurantService;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    private RestaurantRepository restaurantRepository;

    private MenuItemRepository menuItemRepository;

    @Before
    public void setUp(){
        restaurantRepository = new RestaurantRepositoryImpl();

        restaurantService = new RestaurantService(restaurantRepository,menuItemRepository);
    }

    @Test
    public void getRestaurant(Long restaurantId){

        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId(),Is.is(1004L));
    }

    @Test
    public void getRestaurants(){
    
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);

        assertThat(restaurant.getId(),Is.is(1004L));

        MenuItem menuItem = restaurant.getMenuItems().get(0);

        assertThat(menuItem.getName(),Is.is("Kimchi"));
    }


}