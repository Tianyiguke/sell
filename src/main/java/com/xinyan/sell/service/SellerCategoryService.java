package com.xinyan.sell.service;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * sxx
 * 2018/11/16 0016
 */
public interface SellerCategoryService {
    //===========================卖家端==============================

    /**
     * 分页查询所有类目
     * @param pageRequest
     * @return
     */
    Page<ProductCategory> findAll(PageRequest pageRequest);

    /**
     * 查询所有类目
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 新增类目
     * @param ProductCategory
     */
    void save(ProductCategory ProductCategory);

    /**
     * 通过categoryId查询类目信息
     * @param categoryId
     * @return
     */
    ProductCategory findProductCategoryByCategoryId(Integer categoryId);

    /**
     * 通过categoryId删除类型信息
     * @param categoryId
     */
    void deleteProductCategoryByCategoryId(Integer categoryId);
}
