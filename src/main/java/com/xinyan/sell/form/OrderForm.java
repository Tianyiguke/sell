package com.xinyan.sell.form;

import lombok.Data;

/**
 * Administrator
 * 2018/11/16 17:08
 * 表单数据
 */
@Data
public class OrderForm<T> {

    /*买家姓名*/
    private String name;

    /*买家电话*/
    private String phone;

    /*买家地址*/
    private String address;

    /*买家微信openid*/
    private String openid;

    /*商品信息*/
    private T items;

}
