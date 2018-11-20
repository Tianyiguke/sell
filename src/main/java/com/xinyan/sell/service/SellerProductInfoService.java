package com.xinyan.sell.service;

import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * sxx
 * 2018/11/15 0015
 */

public interface SellerProductInfoService {
    //===========================卖家端==============================

    /**
     * 分页查询所有商品
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAllPage(Pageable pageable);

    /**
     * 查询所有商品
     * @return
     */
    List<ProductInfo> findAll();

    /**
     * 新增商品
     * @param productInfo
     */
    void save(ProductInfo productInfo);



    /**
     * 通过productId查询商品 并修改商品状态
     * @param productId
     * @return
     */
    ProductInfo findByProductIdAndUpdateStatus(String productId);

    /**
     * 通过productId查询商品
     * @param productId
     * @return
     */
    ProductInfo findByProductId(String productId);

    /**
     * 保存商品信息
     * @param productInfo
     */
    void saveUpdateProduct(ProductInfo productInfo);

}
