package com.xinyan.sell.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xinyan.sell.common.SellException;
import com.xinyan.sell.dto.CardDTO;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.form.OrderForm;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.utils.JSONUtil;
import com.xinyan.sell.utils.ResultVOUtil;
import com.xinyan.sell.vo.OrderDetailInfoVO;
import com.xinyan.sell.vo.OrderDetailVO;
import com.xinyan.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

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
     * 创建订单
     * @return
     */
    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】订单参数有误，OrderForm:[]",orderForm);
            throw new SellException(ResultStatus.ORDER_MSG_HAS_ERROR);
        }

        /* OrderForm 转 OrderDTO */
        OrderDTO orderDTO = new OrderDTO();
        OrderMaster orderMaster = new OrderMaster();
        List<OrderDetail> orderDetailList = new ArrayList<>();

        List<CardDTO> cardDTOList = JSONUtil.readValue(orderForm.getItems(), new TypeReference<List<CardDTO>>() {});

        if(cardDTOList.size() == 0){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultStatus.ORDER_CARD_IS_NULL);
        }

        orderMaster.setBuyerOpenid(orderForm.getOpenid());
        orderMaster.setBuyerName(orderForm.getName());
        orderMaster.setBuyerPhone(orderForm.getPhone());
        orderMaster.setBuyerAddress(orderForm.getAddress());
        orderDTO.setOrderMaster(orderMaster);

        for (CardDTO cardDTO: cardDTOList) {
            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setProductId(cardDTO.getProductId());
            orderDetail.setProductQuantity(cardDTO.getProductQuantity());
            orderDetailList.add(orderDetail);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        /* 调用业务接口 */
        OrderDTO resultDTO = orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",resultDTO.getOrderMaster().getOrderId());
        return ResultVOUtil.success(map);
    }

    public ResultVO orderList(@RequestParam("openid") String openid){
        return  null;
    }

    /**
     * 买家订单详情
     * @return
     */
    @RequestMapping("/detail")
    public ResultVO buyerOrderDetail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){

        //订单详情（订单id）
        List<OrderDetail> orderDetailList = orderService.findDetailByOrderId(orderId);

        if(orderDetailList == null){
            throw new SellException(ResultStatus.ORDER_DETAIL_NOT_EXIST);
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
