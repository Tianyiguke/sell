package com.xinyan.sell.service;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        OrderMaster orderMaster = new OrderMaster();
        List<OrderDetail> orderDetailList = new ArrayList<>();

        String openid = KeyUtil.getUUID();

        orderMaster.setOrderId(KeyUtil.getUUID());
        orderMaster.setBuyerName("王五");
        orderMaster.setBuyerAddress("资信达大厦403前台");
        orderMaster.setBuyerPhone("18988828889");
        orderMaster.setBuyerOpenid(openid);
        orderMaster.setPayStatus(0);
        orderMaster.setOrderAmount(new BigDecimal("150"));
        orderMaster.setOrderStatus(1);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(KeyUtil.getUUID());
        orderDetail.setOrderId(openid);
        orderDetail.setProductId("2c2bdf1725284995b4ed3e82cc041e22");
        orderDetail.setProductName("老北京烤鸭");
        orderDetail.setProductPrice(new BigDecimal("30"));
        orderDetail.setProductQuantity(3);
        orderDetail.setProductIcon("https://f11.baidu.com/it/u=1283627459,2832815830&fm=72");
        orderDetailList.add(orderDetail);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setDetailId(KeyUtil.getUUID());
        orderDetail2.setOrderId(openid);
        orderDetail2.setProductId("13dbcc1382c5421db58dee1e0adf0a15");
        orderDetail2.setProductName("辣鸡");
        orderDetail2.setProductPrice(new BigDecimal("30"));
        orderDetail2.setProductQuantity(2);
        orderDetail2.setProductIcon("http");
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderMaster(orderMaster);
        orderDTO.setOrderDetailList(orderDetailList);

        orderService.create(orderDTO);

    }
}