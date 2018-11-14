package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
            @Autowired
            private ProductCategoryRepository repository;
            @Test
            public void findoneTest(){
                ProductCategory productCategory = repository.findOne(1);
                Assert.assertNotNull(productCategory);
            }
}