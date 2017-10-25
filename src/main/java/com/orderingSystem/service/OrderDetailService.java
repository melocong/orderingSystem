package com.orderingSystem.service;

import com.orderingSystem.pojo.OrderDetail;
import com.orderingSystem.dao.OrderDetailDao;
import com.orderingSystem.param.OrderDetailQueryParam;
import com.orderingSystem.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;


    public String create(OrderDetail orderDetail){
        //may be need verity orderDetail properties
        orderDetailDao.insert(orderDetail);
        return orderDetail.getId();
    }


    public void delete(String id){
        //may be need verity some privilege key
        orderDetailDao.delete(id);
    }

    public void update(OrderDetail orderDetail){
        orderDetailDao.update(orderDetail);
    }


    public Page<OrderDetail> query(OrderDetailQueryParam param){
        Page<OrderDetail> page = new Page<OrderDetail>();
        page.setPageNo(param.getPageNo());
        page.setPageSize(param.getPageSize());
        page.setTotalNum(orderDetailDao.queryCount(param));
        if(page.isOverCount()){
            int pageNo = page.getMaxPageNo();
            page.setPageNo(pageNo);
        }
        page.setResults(orderDetailDao.query(param));
        return page;
    }

}
