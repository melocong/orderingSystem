package com.orderingSystem.service;

import com.orderingSystem.pojo.ReceiptNum;
import com.orderingSystem.dao.ReceiptNumDao;
import com.orderingSystem.param.ReceiptNumQueryParam;
import com.orderingSystem.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptNumService {

    @Autowired
    private ReceiptNumDao receiptNumDao;


    public String create(ReceiptNum receiptNum){
        //may be need verity receiptNum properties
        receiptNumDao.insert(receiptNum);
        return receiptNum.getId();
    }


    public void delete(String id){
        //may be need verity some privilege key
        receiptNumDao.delete(id);
    }

    public void update(ReceiptNum receiptNum){
        receiptNumDao.update(receiptNum);
    }


    public Page<ReceiptNum> query(ReceiptNumQueryParam param){
        Page<ReceiptNum> page = new Page<ReceiptNum>();
        page.setPageNo(param.getPageNo());
        page.setPageSize(param.getPageSize());
        page.setTotalNum(receiptNumDao.queryCount(param));
        if(page.isOverCount()){
            int pageNo = page.getMaxPageNo();
            page.setPageNo(pageNo);
        }
        page.setResults(receiptNumDao.query(param));
        return page;
    }

}
