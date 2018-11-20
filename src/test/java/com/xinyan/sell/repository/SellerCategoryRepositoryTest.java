package com.xinyan.sell.repository;

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
public class SellerCategoryRepositoryTest {

    @Autowired
    private SellerCategoryService sellerCategoryService;

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("aaa");
        productCategory.setCategoryType(1);
        sellerCategoryService.save(productCategory);
    }

    @Test
    public void delete(){
        sellerCategoryService.deleteProductCategoryByCategoryId(6);
    }
}