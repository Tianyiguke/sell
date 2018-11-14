package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ProductCategoryRepositoryTest 接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
            @Autowired
            private ProductCategoryRepository repository;

            //单个查询
            @Test
            public void findOneTest(){
                ProductCategory productCategory = repository.findOne(1);
                Assert.assertNotNull(productCategory);
            }

            //保存
            @Test
            public void saveTest(){
                ProductCategory productCategory = new ProductCategory();
                productCategory.setCategoryName("热销榜");
                productCategory.setCategoryType(8);
                ProductCategory result = repository.save(productCategory);
                Assert.assertNotEquals(null,result);
            }


            //自定义测试
            @Test
            public void findByCategoryTypeInTest(){
                List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(Arrays.asList(6, 7));
                Assert.assertNotEquals("根据多个类型查询类目", productCategoryList);
            }
}