package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 1720
 * OrderMaster数据访问层接口
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    /**
     * 根据买家微信openid查找订单列表
     * @return
     */
    public List<OrderMaster> findOrderMasterByBuyerOpenid(String orpenId);

}
