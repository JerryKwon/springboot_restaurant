package com.fastcampus.restaurant.entity;

import java.util.ArrayList;
import java.util.List;

// import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

// @Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Restaurant {

    private Long id;

    private String name;

    private String address;

    public Restaurant(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    private List<MenuItem> menuItems = new ArrayList<>();

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem){
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems){
        for(MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }

}