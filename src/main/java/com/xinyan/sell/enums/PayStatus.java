package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * 支付状态
 */
@Getter
public enum PayStatus {
    WAIT(0,"待支付"),
    SUCCESS(1,"已支付");

    private Integer code;
    private String message;

    PayStatus(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
