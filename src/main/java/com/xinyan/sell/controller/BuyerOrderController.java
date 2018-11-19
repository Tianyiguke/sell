package com.xinyan.sell.controller;

import com.xinyan.sell.common.SellException;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.utils.ResultVOUtil;
import com.xinyan.sell.vo.OrderDetailInfoVO;
import com.xinyan.sell.vo.OrderDetailVO;
import com.xinyan.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 不夏
 * 2018/11/17 9:31
 * 买家订单Controller
 */
@Slf4j
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 买家订单详情
     * @return
     */
    @RequestMapping("/detail")
    public ResultVO buyerOrderDetail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){

        //订单详情（订单id）
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
           orderDetailList = orderService.findDetailByOrderId(orderId);
        }catch (SellException e){
            log.error(ResultStatus.ORDER_DETAIL_NOT_EXIST.getMessage());
            return ResultVOUtil.faild(null);
        }



        //订单主表（订单id）
        OrderMaster orderMasters = orderService.findOrderMasterById(orderId);

        OrderDetailVO orderDetailVO = new OrderDetailVO();

        BeanUtils.copyProperties(orderMasters,orderDetailVO);
        orderDetailVO.setUpdateTime(new Date());

        //拼接数据
        List<OrderDetailInfoVO> orderDetailInfoVOList = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetailList){
            OrderDetailInfoVO orderDetailInfoVO = new OrderDetailInfoVO();
            BeanUtils.copyProperties(orderDetail,orderDetailInfoVO);
            orderDetailInfoVO.setProductImage(orderDetail.getProductIcon());

            orderDetailInfoVOList.add(orderDetailInfoVO);
        }

        orderDetailVO.setOrderDetailInfoVOList(orderDetailInfoVOList);
        return ResultVOUtil.success(orderDetailVO);
    }
}
