package com.orderingSystem.dao;

import com.orderingSystem.pojo.ReceiptNum;
import com.orderingSystem.param.ReceiptNumQueryParam;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptNumDao {
    void insert(ReceiptNum receiptNum);

    void update(ReceiptNum receiptNum);

    void delete(String id);

    List<ReceiptNum>query(ReceiptNumQueryParam param);

    long queryCount(ReceiptNumQueryParam param);
}
