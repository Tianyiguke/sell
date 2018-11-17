package com.xinyan.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Administrator
 * 2018/11/16 19:29
 * 订单详情VO
 */
@Data
@DynamicUpdate
public class OrderDetailVO {

    /* 订单编号 */
    @JsonProperty("orderId")
    private String orderId;

    /* 买家姓名 */
    @JsonProperty("buyerName")
    private String buyerName;

    /* 买家电话 */
    @JsonProperty("buyerPhone")
    private String buyerPhone;

    /* 买家地址 */
    @JsonProperty("buyerAddress")
    private String buyerAddress;

    /* 买家微信openid */
    @JsonProperty("buyerOpenid")
    private String buyerOpenid;

    /* 订单总金额 */
    @JsonProperty("orderAmount")
    private BigDecimal orderAmount;

    /* 订单状态 */
    @JsonProperty("orderStatus")
    private Integer orderStatus;

    /* 支付状态 */
    @JsonProperty("payStatus")
    private Integer payStatus;

    /* 创建时间 */
    @JsonProperty("createTime")
    private Date createTime;

    /* 修改时间 */
    @JsonProperty("updateTime")
    private Date updateTime;

    /* 订单详情列表 */
    @JsonProperty("orderDetailList")
    private List<OrderDetailVO> orderDetailVOList;

}
