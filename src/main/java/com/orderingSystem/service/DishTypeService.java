package com.orderingSystem.service;

import com.orderingSystem.pojo.DishType;
import com.orderingSystem.dao.DishTypeDao;
import com.orderingSystem.param.DishTypeQueryParam;
import com.orderingSystem.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishTypeService {

    @Autowired
    private DishTypeDao dishTypeDao;


    public String create(DishType dishType){
        //may be need verity dishType properties
        dishTypeDao.insert(dishType);
        return dishType.getId();
    }


    public void delete(String id){
        //may be need verity some privilege key
        dishTypeDao.delete(id);
    }

    public void update(DishType dishType){
        dishTypeDao.update(dishType);
    }


    public Page<DishType> query(DishTypeQueryParam param){
        Page<DishType> page = new Page<DishType>();
        page.setPageNo(param.getPageNo());
        page.setPageSize(param.getPageSize());
        page.setTotalNum(dishTypeDao.queryCount(param));
        if(page.isOverCount()){
            int pageNo = page.getMaxPageNo();
            page.setPageNo(pageNo);
        }
        page.setResults(dishTypeDao.query(param));
        return page;
    }

}
