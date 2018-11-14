package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 不夏
 * 2018/11/14
 * ProductInfo 数据访问层接口
 */
@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

}
