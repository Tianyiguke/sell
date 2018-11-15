package com.xinyan.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 不夏
 * 2018/11/14 20:21
 * 商品信息VO
 */
@Data
public class ProductInfoVO {

    /*商品ID*/
    @JsonProperty("id")
    private String productId;

    /*商品名称*/
    @JsonProperty("name")
    private String productName;

    /*商品单价*/
    @JsonProperty("price")
    private BigDecimal productPrice;

    /*商品描述*/
    @JsonProperty("description")
    private String productDescription;

    /*商品小图*/
    @JsonProperty("icon")
    private String productIcon;
}
