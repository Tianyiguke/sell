package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * 订单状态
 */
@Getter
public enum OrderStatus {
    NEW(0,"新订单"),
    FINISHED(1,"已完结"),
    CANCEL(2,"已取消");

    private Integer code;
    private String massage;

    OrderStatus(Integer code,String massage){
        this.code = code;
        this.massage = massage;
    }
}
