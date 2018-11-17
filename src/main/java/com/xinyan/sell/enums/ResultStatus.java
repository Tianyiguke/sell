package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * Administrator
 * 2018/11/16 0016
 * 异常状态枚举类
 */
@Getter
public enum ResultStatus {

    PRODUCT_NOT_EXIST(0,"商品不存在"),
    PRODUCT_STOCK_ERROR(1,"商品库存不足"),
    ORDER_NOT_EXIST(2,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(3,"订单详情不存在");

    private Integer Code;
    private String message;

    ResultStatus(Integer code,String message){
        this.Code=code;
        this.message=message;
    }
}
