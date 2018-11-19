package com.xinyan.sell.service.impl;

import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.ProductInfoRepository;
import com.xinyan.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 不夏
 * 2018/11/14 18:36
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    /**
     * 根据 id 查找单个商品
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    /**
     * 查找所有商品
     * @return
     */
    @Override
    public List<ProductInfo> findAll() {
        return repository.findAll();
    }

    /**
     * 根据商品状态查找
     * @param productStatus
     * @return
     */
    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        return repository.findByProductStatus(productStatus);
    }

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {

        PageRequest pageRequest = new PageRequest(pageable.getPageNumber(),pageable.getPageSize());
        Page<ProductInfo> productInfoPage = repository.findAll(pageRequest);
        return productInfoPage;
    }
}
