package com.xinyan.sell.po;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "order_master")
@Entity
@DynamicUpdate
public class OrderMaster {

    /* 订单编号 */
    @Id
    private String orderId;

    /* 买家姓名 */
    private String buyerName;

    /* 买家电话 */
    private String buyerPhone;

    /* 买家地址 */
    private String buyerAdress;

    /* 买家微信openid */
    private String buyerOpenid;

    /* 订单总金额 */
    private BigDecimal orderAmount;

    /* 订单状态 */
    private Integer orderStatus;

    /* 支付状态 */
    private Integer payStatus;

    /* 创建时间 */
    private Date createTime;
}
