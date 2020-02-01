package com.fastcampus.respository;

import static org.junit.Assert.assertThat;

import com.fastcampus.restaurant.entity.Restaurant;
// import com.fastcampus.restaurant.repository.RestaurantRepository;
import com.fastcampus.restaurant.restaurant.DemoApplicationTests;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class RestaurantRepositoryTest extends DemoApplicationTests{

    // @Autowired
    // RestaurantRepository restaurantRepository;

    @Test
    public void create(){
        Restaurant restaurant = Restaurant.builder().build();
        assertThat(restaurant.getName(),Is.is("Bob zip"));
    }


}