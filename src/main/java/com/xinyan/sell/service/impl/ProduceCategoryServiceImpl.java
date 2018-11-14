package com.xinyan.sell.service.impl;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.repository.ProductCategoryRepository;
import com.xinyan.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 0014
 *
 * 类目 业务接口实现类
 */
@Service
public class ProduceCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    /**
     * 查询单个
     * @param categoryId
     * @return
     */
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    /**
     * 查询列表
     * @return
     */
    @Override
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * 查询多个
     * @param categoryTypeList
     * @return
     */
    @Override
    public List<ProductCategory> findAll(List<Integer> categoryTypeList) {
        return categoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
