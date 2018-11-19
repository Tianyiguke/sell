package com.xinyan.sell.dto;

import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import lombok.Data;

import java.util.List;

/**
 * Administrator
 * 2018/11/16 17:12
 * 订单传输对象
 */
@Data
public class OrderDTO {

    private OrderMaster orderMaster;

    private List<OrderDetail> orderDetailList;

}
