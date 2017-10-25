package com.orderingSystem.dao;

import com.orderingSystem.pojo.OrderDetail;
import com.orderingSystem.param.OrderDetailQueryParam;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDao {
    void insert(OrderDetail orderDetail);

    void update(OrderDetail orderDetail);

    void delete(String id);

    List<OrderDetail>query(OrderDetailQueryParam param);

    long queryCount(OrderDetailQueryParam param);
}
