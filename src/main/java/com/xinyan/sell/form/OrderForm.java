package com.xinyan.sell.form;

import lombok.Data;

/**
 * Administrator
 * 2018/11/16 17:08
 * 表单数据
 */
@Data
public class OrderForm<T> {

    private String name;
    private String phone;
    private String address;
    private String openid;
    private T items;

}
