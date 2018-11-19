package com.xinyan.sell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Administrator
 * 2018/11/19 11:23
 * 订单商品
 */
@Data
public class CardDTO {
    /* 商品编号 */
    @JsonProperty("productId")
    private String productId;

    /* 商品数量 */
    @JsonProperty("productQuantity")
    private Integer productQuantity;
}
