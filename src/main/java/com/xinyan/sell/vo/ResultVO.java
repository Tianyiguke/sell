package com.xinyan.sell.vo;

import lombok.Data;
import org.springframework.validation.BindingResult;

/**
 * 不夏
 * 2018/11/14 19:51
 * 商品列表VO
 */
@Data
public class ResultVO<T> {

    /*返回状态码*/
    private Integer code;


    /*返回信息*/
    private String msg;

    /*返回JSON数据*/
    private T data;
}
