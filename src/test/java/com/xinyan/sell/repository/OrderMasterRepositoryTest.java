package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
    @Test
    public void findoneOrder(){
        OrderMaster orderMaster = repository.findOne(KeyUtil.getUUID());
        Assert.assertNotNull("订单未找到",orderMaster);
    }
    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1ce1fa50e05c49f4b5fbff18af7b3ab0");
        orderMaster.setBuyerName("李四");
        orderMaster.setBuyerAddress("资信达大厦403前台");
        orderMaster.setBuyerPhone("18982928889");
        orderMaster.setBuyerOpenid(KeyUtil.getUUID());
        orderMaster.setPayStatus(0);
        orderMaster.setOrderAmount(new BigDecimal("150"));
        orderMaster.setOrderStatus(1);
        repository.save(orderMaster);

    }

}