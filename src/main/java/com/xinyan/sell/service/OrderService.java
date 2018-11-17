package com.xinyan.sell.service;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;

import java.util.List;

/**
 * Administrator
 * 2018/11/16 17:19
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 订单列表
     * @return
     */
    List<OrderMaster> findOrderList();

    /**
     * 查找单个订单
     * @param orderId
     * @return
     */
    OrderMaster findOrderMasterById(String orderId);

    /**
     * 所有详情列表
     * @return
     */
    List<OrderDetail> findDetailList();

    /**
     * 根据OrderId查找详情
     * @param orderId
     * @return
     */
    List<OrderDetail> findDetailByOrderId(String orderId);
}
