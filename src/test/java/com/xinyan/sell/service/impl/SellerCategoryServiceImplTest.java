package com.xinyan.sell.service.impl;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.service.SellerCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerCategoryServiceImplTest {

    @Autowired
    private SellerCategoryService sellerCategoryService;
    @Test
    public void findProductCategoryByCategoryId() {
        ProductCategory category = sellerCategoryService.findProductCategoryByCategoryId(1);
        System.out.println(category);

    }
}