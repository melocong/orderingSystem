package com.orderingSystem.dao;

import com.orderingSystem.pojo.Order;
import com.orderingSystem.param.OrderQueryParam;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    void insert(Order order);

    void update(Order order);

    void delete(String id);

    List<Order>query(OrderQueryParam param);

    long queryCount(OrderQueryParam param);
}
