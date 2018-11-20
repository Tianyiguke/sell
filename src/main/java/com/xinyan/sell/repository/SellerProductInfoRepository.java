package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * sxx
 * 2018/11/15 0015
 */
@Repository
public interface SellerProductInfoRepository extends JpaRepository<ProductInfo,String> {

    /**
     * 通过productId 查询商品信息
     * @param productId
     * @return
     */
    public ProductInfo findByProductId(String productId);
}
