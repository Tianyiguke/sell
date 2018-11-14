package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

/**
 * ProductCategoryRepositoryTest 接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
            @Autowired
            private ProductCategoryRepository repository;

    /**
     * 查询单个对象
     */
    @Test
    public void findoneTest(){
                ProductCategory productCategory = repository.findOne(1);
                Assert.assertNotNull("根据ID查询类目",productCategory);
    }
    /**
     * 保存对象
     *
     */
    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("女神-精");
        productCategory.setCategoryType(7);
        ProductCategory category = repository.save(productCategory);
        Assert.assertNotNull("添加商品类目",category);
    }
    @Test
    public void findByCategoryNameLikeTest(){
        ProductCategory productCategory = repository.findByCategoryNameLike("%女%");
        System.out.println(productCategory);
    }
}