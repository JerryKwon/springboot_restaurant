package com.fastcampus.restaurant.interfaces;

public abstract interface CrudInterfaces<Entity>{

    public Entity create(Entity entity);

    public Entity read(Long id);

    public Entity update(Entity entity);

    public void delete(Long id);

}