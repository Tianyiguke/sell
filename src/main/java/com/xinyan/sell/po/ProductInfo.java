package com.xinyan.sell.po;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 不夏
 * 2018/11/14
 * PO持久化数据对象类
 * ProductInfo
 */

@Table(name="product_info")
@Data
@Entity
@DynamicUpdate
public class ProductInfo {

    /*商品ID*/
    @Id
    private String productId;

    /*商品名称*/
    private String productName;

    /*商品单价*/
    private BigDecimal productPrice;

    /*商品库存*/
    private Integer productStock;

    /*商品描述*/
    private String productDescription;

    /*商品小图*/
    private String productIcon;

    /*商品状态 0: 上架  1：下架*/
    private Integer productStatus = 0;

    /*类目编号*/
    private Integer categoryType;

    /*创建时间*/
    private Date createTime;

}
