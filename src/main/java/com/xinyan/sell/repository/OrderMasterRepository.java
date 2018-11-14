package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Administrator
 * 2018/11/14 1720
 * OrderMaster数据访问层接口
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

}
