package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * Administrator
 * 2018/11/14 0014
 * 商品状态
 */
@Getter
public enum ProductStatus {
    /**
     * 商品上架
     */
    UP(0,"上架"),
    /**
     * 商品下架
     */
    DOWN(1,"下架");
    /**
     * 商品状态编号
     */
    private Integer code;
    /**
     * 商品状态信息
     */
    private String message;

    ProductStatus(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
