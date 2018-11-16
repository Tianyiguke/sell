package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void findone(){
        OrderDetail orderDetail =repository.findOne(UUID.randomUUID().toString());
        Assert.assertNotNull(orderDetail);
    }

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(KeyUtil.getUUID());
        orderDetail.setOrderId(KeyUtil.getUUID());
        orderDetail.setProductId("2c2bdf1725284995b4ed3e82cc041e22");
        orderDetail.setProductName("老北京烤鸭");
        orderDetail.setProductPrice("30");
        orderDetail.setProductQuantity(5);
        orderDetail.setProductIcon("https://f11.baidu.com/it/u=1283627459,2832815830&fm=72");
        final OrderDetail orderdetail = repository.save(orderDetail);
        Assert.assertNotNull("保存失败",orderdetail);
    }

    @Test
    public void findOrderDetailByOrderId(){
        List<OrderDetail> orderDetailByOrderId = repository.findOrderDetailByOrderId("1ce1fa50e05c49f4b5fbff18af7b3ab0");
        Assert.assertNotNull("未找到订单详情",orderDetailByOrderId);
    }


}