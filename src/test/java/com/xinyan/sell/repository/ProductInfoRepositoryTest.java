package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import static org.junit.Assert.*;

/**
 * ProductInfoRepository 接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findAll(){
        List<ProductInfo> productInfoList = repository.findAll();
        Assert.assertNotNull(productInfoList);
    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(UUID.randomUUID().toString().replace("-",""));
        productInfo.setProductName("老北京烤鸭");
        productInfo.setProductPrice(new BigDecimal("30"));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("最好吃最正宗的郝式老北京烤鸭");
        productInfo.setProductIcon("https://f11.baidu.com/it/u=1283627459,2832815830&fm=72");
        productInfo.setCategoryType(1);
        repository.save(productInfo);
    }

    @Test
    public void findByProductStatus(){
        List<ProductInfo> productInfoList = repository.findByProductStatus(1);
        Assert.assertNotNull("未找到商品",productInfoList);
    }



}