package com.fastcampus.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fastcampus.restaurant.controller.RestaurantController;
import com.fastcampus.restaurant.repository.MenuItemRepository;
import com.fastcampus.restaurant.repository.MenuItemRepositoryImpl;
import com.fastcampus.restaurant.repository.RestaurantRepository;
import com.fastcampus.restaurant.repository.RestaurantRepositoryImpl;
import com.fastcampus.restaurant.restaurant.DemoApplication;
import com.fastcampus.restaurant.service.RestaurantService;

import org.hamcrest.core.StringContains;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class) // 테스트를 요청하기 위한 대상을 지정하는 어노테이션
@WebMvcTest(RestaurantController.class) // 무엇을 테스트할 것인지 정의하는 어노테이션
@ContextConfiguration(classes = DemoApplication.class)
public class RestaurantControllerTest{

    @Autowired
    private MockMvc mvc;

    @SpyBean(RestaurantService.class)
    private RestaurantService restaurantService;

    @SpyBean(RestaurantRepositoryImpl.class) // 컨트롤러에 원하는 객체 주입 가능
    private RestaurantRepository restaurantRepository;

    // @SpyBean(MenuItemRepositoryImpl.class)
    // private MenuItemRepository MenuItemRepository;

    // @Autowired
    // private RestaurantRepository restaurantRepository;

    // @GetMapping("/api/restaurant")
    // public Restaurant read(@RequestParam Long restaurantId){

    //     return restaurantRepository.findById(restaurantId).map(restaurant -> restaurant).orElseGet((restaurant) -> {return Restaurant.builder().id(0).name("Error").address("Error").build()});
    // }

    @Test
    public void list() throws Exception{
        mvc.perform(get("/restaurants")).andExpect(status().isOk())
                                        .andExpect(content().string(StringContains.containsString("\"id\":1")))
                                        .andExpect(content().string(StringContains.containsString("\"name\":\"Bob zip\"")));
    }

    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
            .andExpect(status().isOk())
            .andExpect(content().string(StringContains.containsString("\"id\":1")))
            .andExpect(content().string(StringContains.containsString("\"name\":\"Bob zip\"")));
    }

}