package com.fastcampus.restaurant.controller;

import java.util.List;

import com.fastcampus.restaurant.entity.MenuItem;
import com.fastcampus.restaurant.entity.Restaurant;
import com.fastcampus.restaurant.repository.MenuItemRepository;
import com.fastcampus.restaurant.repository.RestaurantRepository;
import com.fastcampus.restaurant.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Component의 일종
// @RequestMapping("/restaurant")
public class RestaurantController  {

    //의존성 - 둘 이상의 객체가 서로 협력하는 것
    //A가 B에 의존한다 => A가 B를 사용한다 => B의 변화는 A에 영향을 미친다.
    //따라서 B를 효과적으로 관리할 필요가 있다.

    //e.g) Controller는 Repository를 사용함.
    //repository를 생성 => 생성한 repository를 controller에 연결
    //Spring IoC Container가 이를 연결하는 역할을 수행함
    //@Component, @AutoWired 어노테이션이 존재.
    
    @Autowired
    private RestaurantService restaurantSerivce;
    
    // @Autowired
    // private RestaurantRepository restaurantRepository;

    // @Autowired
    // private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        
        List<Restaurant> restaurants = restaurantSerivce.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        
        Restaurant restaurant = restaurantSerivce.getRestaurant(id);

        // List<Restaurant> restaurants = new ArrayList<>();

        // restaurants.add(new Restaurant(1004L,"Bob zip","Seoul"));
        // restaurants.add(new Restaurant(2020L,"Bob zip","Seoul"));

        // Restaurant restaurant = restaurants.stream()
        //                                     .filter(r -> r.getId().equals(id))
        //                                     .findFirst().orElse(null);

        // Restaurant restaurant = restaurantRepository.findById(id);

        // List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);

        // restaurant.setMenuItems(menuItems);

        return restaurant;

    }

    // @Override
    // public Restaurant create(Restaurant entity) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @GetMapping("id")
    // @Override
    // public Restaurant read(Long id) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public Restaurant update(Restaurant entity) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public void delete(Long id) {
    //     // TODO Auto-generated method stub

    // }

    

}