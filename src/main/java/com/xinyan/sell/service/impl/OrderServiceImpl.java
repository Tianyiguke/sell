package com.xinyan.sell.service.impl;

import com.xinyan.sell.common.SellException;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.OrderStatus;
import com.xinyan.sell.enums.PayStatus;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.OrderDetailRepository;
import com.xinyan.sell.repository.OrderMasterRepository;
import com.xinyan.sell.repository.ProductInfoRepository;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.utils.KeyUtil;
import com.xinyan.sell.vo.OrderDTOVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
        String orderId= KeyUtil.getUUID();

        /* 计算订单总额 */
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()
             ) {
            ProductInfo productInfo = productInfoRepository.findOne(orderDetail.getProductId());
            if(productInfo.getProductStock().compareTo(orderDetail.getProductQuantity())== -1){

            }else{
                orderDetail.setOrderId(orderId);
                orderDetail.setDetailId(KeyUtil.getUUID());
                orderDetail.setProductName(productInfo.getProductName());
                orderDetail.setProductIcon(productInfo.getProductIcon());
                orderDetail.setProductPrice(productInfo.getProductPrice());
                orderDetail.setCreateTime(new Date());
                sum = sum.add(productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()+"")));
            }
        }
        orderDTO.getOrderMaster().setOrderAmount(sum);
        orderDTO.getOrderMaster().setOrderId(orderId);
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
     * 根据openid查找订单
     * @param openId
     * @return
     */
    @Override
    public List<OrderMaster> findOrderByOpendId(String openId) {
        return orderMasterRepository.findOrderMasterByBuyerOpenid(openId);
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
     * 取消订单
     * @param orderid
     */
    @Override
    public void cancel(String orderid) {
        OrderMaster orderMaster = orderMasterRepository.findOne(orderid);
        orderMaster.setOrderStatus(OrderStatus.CANCEL.getCode());

        orderMasterRepository.save(orderMaster);

        List<OrderDetail> orderDetailList = orderDetailRepository.findOrderDetailByOrderId(orderid);
        for (OrderDetail orderDetail:orderDetailList) {
            ProductInfo productInfo = productInfoRepository.findOne(orderDetail.getProductId());
            productInfo.setProductStock(productInfo.getProductStock() + orderDetail.getProductQuantity());
            productInfoRepository.save(productInfo);
        }
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

    /**
     * 根据OrderId修改订单状态
     * @param orderId
     * @return
     */
    @Override
    public OrderMaster findUpdateOrderMasterByIdStatus(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        return orderMaster;
    }

    /**
     * 保存订单
     * @param orderMaster
     */
    @Override
    public void findSaveOrderMaster(OrderMaster orderMaster) {
        orderMasterRepository.save(orderMaster);
    }

    /**
     * 查询订单(分页)
     * @param pageRequest
     * @return
     */
    @Override
    public Page<OrderDTOVO> findList(PageRequest pageRequest) {

        Page<OrderMaster> orderMasters = orderMasterRepository.findAll(pageRequest);
        List<OrderDTOVO> orderDTOVOS = new ArrayList<>();

        for(OrderMaster orderMaster : orderMasters){
            OrderDTOVO orderDTOVO = new OrderDTOVO();
            BeanUtils.copyProperties(orderMaster,orderDTOVO);

            if(orderDTOVO.getOrderId().equals(orderMaster.getOrderId())){
                int orderStatus = orderMaster.getOrderStatus();
                switch (orderStatus){
                    case 0:
                        orderDTOVO.setOrderStatusStr(OrderStatus.NEW.getMassage());
                        break;
                    case 1:
                        orderDTOVO.setOrderStatusStr(OrderStatus.FINISHED.getMassage());
                        break;
                    case 2:
                        orderDTOVO.setOrderStatusStr(OrderStatus.CANCEL.getMassage());
                        break;
                }
            }
            if(orderDTOVO.getOrderId().equals(orderMaster.getOrderId())){
                int payStatus = orderMaster.getPayStatus();
                switch (payStatus){
                    case 0:
                        orderDTOVO.setPayStatusStr(PayStatus.WAIT.getMessage());
                        break;
                    case 1:
                        orderDTOVO.setPayStatusStr(PayStatus.SUCCESS.getMessage());
                        break;
                }
            }
            orderDTOVOS.add(orderDTOVO);
        }
        Page<OrderDTOVO> orderDTOVOPage = new PageImpl<>(orderDTOVOS, pageRequest, orderMasters.getTotalElements());
        return orderDTOVOPage;
    }
}
