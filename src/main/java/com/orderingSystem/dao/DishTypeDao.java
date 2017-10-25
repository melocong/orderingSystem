package com.orderingSystem.dao;

import com.orderingSystem.pojo.DishType;
import com.orderingSystem.param.DishTypeQueryParam;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface DishTypeDao {
    void insert(DishType dishType);

    void update(DishType dishType);

    void delete(String id);

    List<DishType>query(DishTypeQueryParam param);

    long queryCount(DishTypeQueryParam param);
}
