package com.xinyan.sell.dto;

import com.xinyan.sell.enums.ProductStatus;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * sxx
 * 2018/11/20 0020
 */
@Data
public class ProductInfoDTO {

    /*商品ID*/
    private String productId;

    /*商品名称*/
    private String productName;

    /*商品单价*/
    private BigDecimal productPrice;

    /*商品库存*/
    private Integer productStock;

    /*商品状态 0: 上架  1：下架 默认为上架**/
    private Integer productStatus;

    /*商品状态信息**/
    private String  productStatusMsg;

    /*类目编号*/
    private Integer categoryType;

    /*类目名字*/
    private String categoryTypeMsg;

    /*创建时间*/
    private Date createTime;

}
