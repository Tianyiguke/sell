package com.xinyan.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Administrator
 * 2018/11/16 19:56
 * 订单详细信息VO
 */
@Data
public class OrderDetailInfoVO {

    /* 订单详情编号 */
    @JsonProperty("detailId")
    private String detailId;

    /* 订单编号 */
    @JsonProperty("orderId")
    private String orderId;

    /* 商品编号 */
    @JsonProperty("productId")
    private String productId;

    /* 商品名称 */
    @JsonProperty("productName")
    private String productName;

    /* 商品单价 */
    @JsonProperty("productPrice")
    private BigDecimal productPrice;

    /* 商品数量 */
    @JsonProperty("productQuantity")
    private Integer productQuantity;

    /* 商品图标 */
    @JsonProperty("productIcon")
    private String productIcon;

    /* 商品示例图片 */
    @JsonProperty("productImage")
    private String productImage;
}
