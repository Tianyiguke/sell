package com.xinyan.sell.common;

import com.xinyan.sell.enums.ResultStatus;
import lombok.Getter;

/**
 * Administrator
 * 2018/11/16 0016
 * 自定义异常类
 */
@Getter
public class SellException extends RuntimeException {
    //异常编号
    private Integer code;
    //异常构造器
    public SellException(ResultStatus resultStatus){
        super(resultStatus.getMessage());
        this.code=resultStatus.getCode();
    }


}
