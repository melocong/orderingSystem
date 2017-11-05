package com.orderingSystem.dao;

import com.orderingSystem.pojo.Customer;
import com.orderingSystem.param.CustomerQueryParam;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao {
    void insert(Customer customer);

    int update(Customer customer);

    void delete(String id);

    List<Customer>query(CustomerQueryParam param);

    long queryCount(CustomerQueryParam param);

    Customer queryCustInfoByTeleNo(String teleNo);
}
