package com.xinyan.sell.service.impl;

import com.xinyan.sell.enums.ProductStatus;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.SellerProductInfoRepository;
import com.xinyan.sell.service.SellerProductInfoService;
import com.xinyan.sell.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * sxx
 * 2018/11/15 0015
 */
@Service
public class SellerProductInfoServiceImple implements SellerProductInfoService {
    //===========================卖家端==============================

    @Autowired
    private SellerProductInfoRepository sellerProductInfoRepository;
    /**
     * 分页查询所有商品
     * @param page
     * @return
     */
    @Override
    public Page<ProductInfo> findAllPage(Pageable page) {

        PageRequest pageRequest = new PageRequest(page.getPageNumber(),page.getPageSize());
        Page<ProductInfo> SellerProductInfoPage = sellerProductInfoRepository.findAll(pageRequest);
        return SellerProductInfoPage;
    }

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<ProductInfo> findAll() {
        return sellerProductInfoRepository.findAll();
    }


    /**
     * 新增商品
     * @param productInfo
     */
    @Override
    public void save(ProductInfo productInfo) {
        productInfo.setProductId(KeyUtil.getUUID());
        sellerProductInfoRepository.save(productInfo);
    }

    /**
     * 通过productId查询商品 并修改商品状态
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findByProductIdAndUpdateStatus(String productId) {
        ProductInfo productInfo = sellerProductInfoRepository.findByProductId(productId);
        return productInfo;
    }

    /**
     * 通过productId查询商品
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findByProductId(String productId) {
        ProductInfo productInfo = sellerProductInfoRepository.findByProductId(productId);
        return productInfo;
    }


    /**
     * 保存商品信息
     * @param productInfo
     */
    @Override
    public void saveUpdateProduct(ProductInfo productInfo) {
        sellerProductInfoRepository.save(productInfo);
    }


}
