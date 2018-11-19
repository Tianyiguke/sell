package com.xinyan.sell.service.impl;

import com.xinyan.sell.common.SellException;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.OrderDetailRepository;
import com.xinyan.sell.repository.OrderMasterRepository;
import com.xinyan.sell.repository.ProductInfoRepository;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

        BigDecimal sum = new BigDecimal("0");

        /* 计算订单总额 */
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()
             ) {
            ProductInfo productInfo = productInfoRepository.findOne(orderDetail.getProductId());
            if(productInfo.getProductStock().compareTo(orderDetail.getProductQuantity())== -1){

            }else{
                orderDetail.setDetailId(KeyUtil.getUUID());
                orderDetail.setProductName(productInfo.getProductName());
                orderDetail.setProductIcon(productInfo.getProductIcon());
                orderDetail.setProductPrice(productInfo.getProductPrice());
                orderDetail.setCreateTime(new Date());
                sum = sum.add(productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()+"")));
            }
        }
        orderDTO.getOrderMaster().setOrderAmount(sum);
        orderDTO.getOrderMaster().setOrderId(KeyUtil.getUUID());
        orderDTO.getOrderMaster().setOrderStatus(0);
        orderDTO.getOrderMaster().setPayStatus(0);

        /* 添加订单主表 */
        orderMasterRepository.save(orderDTO.getOrderMaster());
        /* 添加订单详情 */
        orderDetailRepository.save(orderDTO.getOrderDetailList());

        /* 修改商品库存 */
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
    public List<OrderDetail> findDetailByOrderId(String orderId) throws SellException {
        return orderDetailRepository.findOrderDetailByOrderId(orderId);
    }
}
