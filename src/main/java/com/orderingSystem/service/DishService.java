package com.orderingSystem.service;

import com.orderingSystem.pojo.Dish;
import com.orderingSystem.dao.DishDao;
import com.orderingSystem.param.DishQueryParam;
import com.orderingSystem.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    @Autowired
    private DishDao dishDao;


    public String create(Dish dish){
        //may be need verity dish properties
        dishDao.insert(dish);
        return dish.getId();
    }


    public void delete(String id){
        //may be need verity some privilege key
        dishDao.delete(id);
    }

    public void update(Dish dish){
        dishDao.update(dish);
    }


    public Page<Dish> query(DishQueryParam param){
        Page<Dish> page = new Page<Dish>();
        page.setPageNo(param.getPageNo());
        page.setPageSize(param.getPageSize());
        page.setTotalNum(dishDao.queryCount(param));
        if(page.isOverCount()){
            int pageNo = page.getMaxPageNo();
            page.setPageNo(pageNo);
        }
        page.setResults(dishDao.query(param));
        return page;
    }

}
