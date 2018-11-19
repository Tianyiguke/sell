package com.xinyan.sell.service;

import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 不夏
 * 2018/11/14
 */

public interface ProductInfoService {

    //===========================买家端==============================

    /**
     * 查询单个商品：ID
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有商品
     * @return
     */
    List<ProductInfo> findAll();

    /**
     * 查询商品：商品状态
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 查询所有商品（分页）
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

}
