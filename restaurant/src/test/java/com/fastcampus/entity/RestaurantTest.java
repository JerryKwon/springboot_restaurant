package com.fastcampus.entity;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import com.fastcampus.restaurant.entity.Restaurant;

import org.junit.jupiter.api.Test;


public class RestaurantTest {

    @Test
    public void create(){

        Restaurant restaurant = new Restaurant(1004L,"Bob zip","Seoul");

        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(), is("Seoul"));
        

    }
}