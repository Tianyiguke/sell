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
 */
@Service
public class ProduceCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findAll(List<Integer> categoryTypeList) {
        return categoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
