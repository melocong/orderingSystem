package com.orderingSystem.service;

import com.orderingSystem.pojo.Customer;
import com.orderingSystem.dao.CustomerDao;
import com.orderingSystem.param.CustomerQueryParam;
import com.orderingSystem.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;


    public String create(Customer customer){
        //may be need verity customer properties
        customerDao.insert(customer);
        return customer.getId();
    }


    public void delete(String id){
        //may be need verity some privilege key
        customerDao.delete(id);
    }

    public void update(Customer customer){
        customerDao.update(customer);
    }


    public Page<Customer> query(CustomerQueryParam param){
        Page<Customer> page = new Page<Customer>();
        page.setPageNo(param.getPageNo());
        page.setPageSize(param.getPageSize());
        page.setTotalNum(customerDao.queryCount(param));
        if(page.isOverCount()){
            int pageNo = page.getMaxPageNo();
            page.setPageNo(pageNo);
        }
        page.setResults(customerDao.query(param));
        return page;
    }

}
