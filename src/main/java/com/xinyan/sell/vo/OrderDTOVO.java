package com.xinyan.sell.vo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Administrator
 * 2018/11/16 19:28
 * 后端订单 VO
 */
@Data
@DynamicUpdate
public class OrderDTOVO {

    /* 订单编号 */
    private String orderId;

    /* 买家姓名 */
    private String buyerName;

    /* 买家电话 */
    private String buyerPhone;

    /* 买家地址 */
    private String buyerAddress;

    /* 买家微信openid */
    private String buyerOpenid;

    /* 订单总金额 */
    private BigDecimal orderAmount;

    /* 订单状态*/
    private String orderStatusStr;

    /* 支付状态*/
    private String payStatusStr;

    /* 创建时间 */
    private Date createTime;

}
