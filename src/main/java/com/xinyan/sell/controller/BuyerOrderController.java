package com.xinyan.sell.controller;

import com.xinyan.sell.utils.ResultVOUtil;
import com.xinyan.sell.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 不夏
 * 2018/11/17 9:31
 * 买家订单Controller
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    /**
     * 买家订单详情
     * @return
     */
    @RequestMapping("/detail")
    public ResultVO buyerOrderDetail(){

        ResultVO resultVO = new ResultVO();


        return ResultVOUtil.success(resultVO);
    }
}
