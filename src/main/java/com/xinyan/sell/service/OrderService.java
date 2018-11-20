package com.xinyan.sell.service;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.vo.OrderDTOVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
     * 根据openid查找订单
     * @param openId
     * @return
     */
    List<OrderMaster> findOrderByOpendId(String openId);

    /**
     * 订单列表
     * @return
     */
    List<OrderMaster> findOrderList();

    /**
     * 取消订单
     * @param orderid
     */
    void cancel(String orderid);

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

    /**
     * 根据OrderId修改订单状态
     * @param orderId
     * @return
     */
    OrderMaster findUpdateOrderMasterByIdStatus(String orderId);

    /**
     * 保存订单
     * @param orderMaster
     */
    void findSaveOrderMaster(OrderMaster orderMaster);

    /**
     * 订单查询(分页)
     * @param pageRequest
     * @return
     */
    Page<OrderDTOVO> findList(PageRequest pageRequest);
}
