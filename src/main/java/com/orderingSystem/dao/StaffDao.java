package com.orderingSystem.dao;

import com.orderingSystem.pojo.Staff;
import com.orderingSystem.param.StaffQueryParam;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDao {
    void insert(Staff staff);

    void update(Staff staff);

    void delete(String id);

    List<Staff>query(StaffQueryParam param);

    long queryCount(StaffQueryParam param);

    Staff queryByLoginName(String loginName);
}
