package com.xinyan.sell.service.impl;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.repository.OrderDetailRepository;
import com.xinyan.sell.repository.OrderMasterRepository;
import com.xinyan.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Administrator
 * 2018/11/16 19:01
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    /**
     * 创建订单
     * @param orderDTO
     */
    @Override
    public void create(OrderDTO orderDTO) {

    }

    /**
     * 订单列表
     * @return
     */
    @Override
    public List<OrderMaster> findOrderList() {
        return orderMasterRepository.findAll();
    }

    /**
     * 根据订单ID查找订单
     * @param orderId
     * @return
     */
    @Override
    public OrderMaster findOrderMasterById(String orderId) {
        return orderMasterRepository.findOne(orderId);
    }

    /**
     * 所有订单详情
     * @return
     */
    @Override
    public List<OrderDetail> findDetailList() {
        return orderDetailRepository.findAll();
    }

    /**
     * 根据订单ID查找订单详情
     * @param orderId
     * @return
     */
    @Override
    public List<OrderDetail> findDetailByOrderId(String orderId) {
        return null;
    }
}
