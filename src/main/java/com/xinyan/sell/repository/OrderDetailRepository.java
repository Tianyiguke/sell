package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 1704
 * OrderDetail数据访问层接口
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    /*
    *   查询多个订单详情：订单id
    */
    List<OrderDetail> findOrderDetailByOrderId(String orderId);

}
