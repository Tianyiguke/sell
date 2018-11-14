package com.xinyan.sell.service;

/**
 * ProductCategoryServiceTest 类目业务接口单元测试
 */

import com.xinyan.sell.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceTest {

    @Autowired
    private ProductCategoryService categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertNotNull(productCategory);

    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findAll1() {
        List<ProductCategory> productCategoryList = categoryService.findAll(Arrays.asList(6, 7, 8));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

}