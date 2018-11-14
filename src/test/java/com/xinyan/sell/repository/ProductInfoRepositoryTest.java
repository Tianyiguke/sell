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
        productInfo.setProductName("农家一碗香");
        productInfo.setProductPrice(new BigDecimal("15"));
        productInfo.setProductStock(20);
        productInfo.setProductDescription("最好吃最正宗的郝式农家一碗香");
        productInfo.setProductIcon("http://img5.imgtn.bdimg.com/it/u=2243535999,2461212792&fm=26&gp=0.jpg");
        productInfo.setCategoryType(1);
        repository.save(productInfo);
    }



}