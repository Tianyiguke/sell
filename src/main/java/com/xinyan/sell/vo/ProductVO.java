package com.xinyan.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xinyan.sell.po.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * 不夏
 * 2018/11/14 20:13
 *
 * 商品VO 对象
 */
@Data
public class ProductVO {

    /*类目名称*/
    @JsonProperty("name")
    private String categoryName;

    /*类目类型*/
    @JsonProperty("type")
    private Integer categoryType;

    /*商品列表*/
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
