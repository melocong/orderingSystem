package com.orderingSystem.service;

import com.orderingSystem.pojo.Staff;
import com.orderingSystem.dao.StaffDao;
import com.orderingSystem.param.StaffQueryParam;
import com.orderingSystem.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    @Autowired
    private StaffDao staffDao;


    public String create(Staff staff){
        //may be need verity staff properties
        staffDao.insert(staff);
        return staff.getId();
    }


    public void delete(String id){
        //may be need verity some privilege key
        staffDao.delete(id);
    }

    public void update(Staff staff){
        staffDao.update(staff);
    }


    public Page<Staff> query(StaffQueryParam param){
        Page<Staff> page = new Page<Staff>();
        page.setPageNo(param.getPageNo());
        page.setPageSize(param.getPageSize());
        page.setTotalNum(staffDao.queryCount(param));
        if(page.isOverCount()){
            int pageNo = page.getMaxPageNo();
            page.setPageNo(pageNo);
        }
        page.setResults(staffDao.query(param));
        return page;
    }

}
