package com.xinyan.sell.service.impl;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.OrderDetailRepository;
import com.xinyan.sell.repository.OrderMasterRepository;
import com.xinyan.sell.repository.ProductInfoRepository;
import com.xinyan.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Administrator
 * 2018/11/16 19:01
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 创建订单
     * @param orderDTO
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {



        orderMasterRepository.save(orderDTO.getOrderMaster());
        orderDetailRepository.save(orderDTO.getOrderDetailList());

        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()
             ) {
             ProductInfo productInfo = productInfoRepository.findOne(orderDetail.getProductId());
             productInfo.setProductStock(productInfo.getProductStock()-orderDetail.getProductQuantity());
             productInfoRepository.save(productInfo);
        }
        return orderDTO;
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
        return orderDetailRepository.findOrderDetailByOrderId(orderId);
    }
}
