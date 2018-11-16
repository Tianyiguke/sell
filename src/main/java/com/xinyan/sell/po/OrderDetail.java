package com.xinyan.sell.po;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name="order_detail")
@Entity
@DynamicUpdate
public class OrderDetail {

    /* 订单详情编号 */
    @Id
    private String detailId;

    /* 订单编号 */
    private String orderId;

    /* 商品编号 */
    private String productId;

    /* 商品名称 */
    private String productName;

    /* 商品单价 */
    private String productPrice;

    /* 商品数量 */
    private Integer productQuantity;

    /* 商品图标 */
    private String productIcon;

    private Date createTime;
}
