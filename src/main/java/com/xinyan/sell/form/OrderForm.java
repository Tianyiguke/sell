package com.xinyan.sell.form;

import com.xinyan.sell.dto.CardDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Administrator
 * 2018/11/16 17:08
 * 表单数据
 */
@Data
public class OrderForm<T> {

    /*买家姓名*/
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /*买家电话*/
    @NotEmpty(message = "电话不能为空")
    private String phone;

    /*买家地址*/
    @NotEmpty(message = "地址不能为空")
    private String address;

    /*买家微信openid*/
    private String openid;

    /*商品信息*/
    private String items;

}
