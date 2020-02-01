package com.fastcampus.restaurant.repository;

import java.util.List;

import com.fastcampus.restaurant.entity.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component // 해당 클래스를 스프링이 직접 관리하게 됨.
// 이로 인해 Controller에서 클래스를 생성할 때 Repository를 자동으로 생성하여 연결함
@Repository
public interface RestaurantRepository {

    List<Restaurant> findAll();

    Restaurant findById(Long id);

}