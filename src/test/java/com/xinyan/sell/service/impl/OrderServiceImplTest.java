package com.xinyan.sell.service.impl;

import com.xinyan.sell.common.SellException;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.repository.OrderDetailRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findDetailByOrderId() {
         List<OrderDetail> orderDetails = repository.findOrderDetailByOrderId("4eb0429ec6ca4bd1875607f7444b3e67");
         if (orderDetails.size() == 0){
             throw new SellException(ResultStatus.ORDER_DETAIL_NOT_EXIST);
         }
    }
}