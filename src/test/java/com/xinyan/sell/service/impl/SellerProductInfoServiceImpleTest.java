package com.xinyan.sell.service.impl;

import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.SellerProductInfoRepository;
import com.xinyan.sell.service.SellerProductInfoService;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerProductInfoServiceImpleTest {

    @Autowired
    private SellerProductInfoRepository productInfoRepository;


    @Test
    public void update(){

        System.out.println(productInfoRepository.findByProductId("2c2bdf1725284995b4ed3e82cc041e22"));
    }

    @Test
    public void updateProductStatusTest(){
        ProductInfo productInfo = productInfoRepository.findByProductId("64b7e4e4d6f3476b879c9e6a9b347907");

        productInfo.setProductStatus(1);

        System.out.println(productInfo);

    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(KeyUtil.getUUID());
        productInfo.setProductName("辣");
        productInfo.setProductPrice(new BigDecimal(30));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("辣");
        productInfo.setProductIcon("http");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(6);
        productInfoRepository.save(productInfo);
    }

}