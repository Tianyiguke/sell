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
    ORDER_DETAIL_NOT_EXIST(3,"订单详情不存在"),
    ORDER_CARD_IS_NULL(4,"购物车为空"),
    ORDER_MSG_HAS_ERROR(5,"创建订单参数错误"),
    CATEGORY_ADD_MSG_ERROR(6,"增加类目参数有误"),
    CATEGORY_GET_MSG_ERROR(7,"获取类目参数有误"),
    CATEGORY_GET_AFTER_MSG_ERROR(8,"获取类目修改后参数有误"),
    CATEGORY_DELETE_MSG_ERROR(9,"删除类目失败"),
    PRODUCT_ADD_MSG_ERROR(10,"增加商品参数有误"),
    PRODUCT_GET_MSG_ERROR(11,"获取商品参数有误"),
    PRODUCT_GET_AFTER_MSG_ERROR(12,"获取商品修改后参数有误"),
    PRODUCT_UP_MSG_ERROR(13,"上架商品失败"),
    PRODUCT_DOWN_MSG_ERROR(14,"下架商品失败"),
    ORDER_CANCEL_FAIL(15,"订单取消失败"),
    ORDER_FINISN_FAIL(16,"订单完结失败"),
    ;

    private Integer Code;
    private String message;

    ResultStatus(Integer code,String message){
        this.Code=code;
        this.message=message;
    }
}
