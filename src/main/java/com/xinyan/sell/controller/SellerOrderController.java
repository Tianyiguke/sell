package com.xinyan.sell.controller;

import com.xinyan.sell.common.SellException;
import com.xinyan.sell.enums.OrderStatus;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.vo.OrderDTOVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Administrator
 * 2018/11/19 0019
 */
@Slf4j
@RequestMapping("/seller/order")
@Controller
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public String orderMasterList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
                                  Map<String, Object> map){
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<OrderDTOVO> orderDTOVOPage = orderService.findList(pageRequest);
        map.put("orderMasterPage", orderDTOVOPage);
        return "order/list";
    }

    /**
     * 查询订单详情
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public String orderDetailList(@RequestParam("orderId") String orderId, Map<String, Object> map){
        List<OrderDetail> detailByOrderId = orderService.findDetailByOrderId(orderId);
        if (detailByOrderId == null) {
            log.error("【获取详情订单id失败】", detailByOrderId);
            throw new SellException(ResultStatus.ORDER_DETAIL_NOT_EXIST);
        }
        OrderMaster orderMasterById = orderService.findOrderMasterById(orderId);
        if (orderMasterById == null) {
            log.error("【获取订单id失败】", orderMasterById);
            throw new SellException(ResultStatus.ORDER_NOT_EXIST);
        }
        map.put("detailByOrderId", detailByOrderId);
        map.put("orderMasterById", orderMasterById);
        return "order/detail";
    }

    /**
     * 完结订单
     * @param orderId
     * @return
    */
    @GetMapping("/finish")
    public String updateOrderMasterStatusByIdFinish(@RequestParam("orderId") String orderId){
        OrderMaster orderMasterByIdStatus = null;

        try{
             orderMasterByIdStatus = orderService.findUpdateOrderMasterByIdStatus(orderId);

        }catch (SellException e){
            log.error(ResultStatus.ORDER_FINISN_FAIL.getMessage());
            return "redirect:list";
        }

        if (orderMasterByIdStatus.getOrderStatus().equals(OrderStatus.NEW.getCode()))
            orderMasterByIdStatus.setOrderStatus(OrderStatus.FINISHED.getCode());

        orderService.saveOrderMaster(orderMasterByIdStatus);
        return "redirect:list";
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public String updateOrderMasterStatusByIdCancel(@RequestParam("orderId") String orderId){
        OrderMaster orderMasterByIdStatus = orderService.findUpdateOrderMasterByIdStatus(orderId);
        orderMasterByIdStatus.setOrderStatus(OrderStatus.CANCEL.getCode());
        if (orderMasterByIdStatus.getOrderStatus() != OrderStatus.FINISHED.getCode()){
            log.error("【修改取消订单状态失败】",orderMasterByIdStatus.getOrderStatus());
            throw new SellException(ResultStatus.ORDER_CANCEL_FAIL);
        }
        orderService.saveOrderMaster(orderMasterByIdStatus);
        return "redirect:list";
    }
}
