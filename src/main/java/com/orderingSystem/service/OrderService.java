package com.orderingSystem.service;

import com.orderingSystem.pojo.Order;
import com.orderingSystem.dao.OrderDao;
import com.orderingSystem.param.OrderQueryParam;
import com.orderingSystem.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;


    public String create(Order order){
        //may be need verity order properties
        orderDao.insert(order);
        return order.getId();
    }


    public void delete(String id){
        //may be need verity some privilege key
        orderDao.delete(id);
    }

    public void update(Order order){
        orderDao.update(order);
    }


    public Page<Order> query(OrderQueryParam param){
        Page<Order> page = new Page<Order>();
        page.setPageNo(param.getPageNo());
        page.setPageSize(param.getPageSize());
        page.setTotalNum(orderDao.queryCount(param));
        if(page.isOverCount()){
            int pageNo = page.getMaxPageNo();
            page.setPageNo(pageNo);
        }
        page.setResults(orderDao.query(param));
        return page;
    }

}
