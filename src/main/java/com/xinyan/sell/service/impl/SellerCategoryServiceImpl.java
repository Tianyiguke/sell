package com.xinyan.sell.service.impl;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.repository.SellerCategoryRepository;
import com.xinyan.sell.service.SellerCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * sxx
 * 2018/11/16 0016
 */
@Service
public class SellerCategoryServiceImpl implements SellerCategoryService {

    @Autowired
    private SellerCategoryRepository sellerCategoryRepository;
    /**
     * 分页查询所有类目
     * @param pageRequest
     * @return
     */
    @Override
    public Page<ProductCategory> findAll(PageRequest pageRequest) {
        return sellerCategoryRepository.findAll(pageRequest);
    }

    /**
     * 查询所有类目
     * @return
     */
    @Override
    public List<ProductCategory> findAll() {
        return sellerCategoryRepository.findAll();
    }

    /**
     *新增类目
     * @param productCategory
     */
    @Override
    public void save(ProductCategory productCategory) {
        sellerCategoryRepository.save(productCategory);
    }

    /**
     * 通过categoryId 查询类目信息
     * @param categoryId
     * @return
     */
    @Override
    public ProductCategory findProductCategoryByCategoryId(Integer categoryId) {
        return sellerCategoryRepository.findByCategoryId(categoryId);
    }

    /**
     * 通过categoryId删除类型信息
     * @param categoryId
     */
    @Override
    public void deleteProductCategoryByCategoryId(Integer categoryId) {
        sellerCategoryRepository.deleteByCategoryId(categoryId);
    }


}
