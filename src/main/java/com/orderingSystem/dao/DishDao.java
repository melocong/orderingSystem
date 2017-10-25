package com.orderingSystem.dao;

import com.orderingSystem.pojo.Dish;
import com.orderingSystem.param.DishQueryParam;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface DishDao {
    void insert(Dish dish);

    void update(Dish dish);

    void delete(String id);

    List<Dish>query(DishQueryParam param);

    long queryCount(DishQueryParam param);
}
