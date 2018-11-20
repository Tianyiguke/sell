package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.SellerProductInfoService;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerProductInfoRepositoryTest {

    @Autowired
    private SellerProductInfoRepository sellerProductInfoRepository;

    @Autowired
    private SellerProductInfoService sellerProductInfoService;

    @Test
    public void findAll(){
        List<ProductInfo> infoList = sellerProductInfoRepository.findAll();
        System.out.println(infoList.size());
    }

    @Test
    public void findAllService(){
        List<ProductInfo> infoList = sellerProductInfoService.findAll();
        System.out.println(infoList.size());
    }

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(KeyUtil.getUUID());
        productInfo.setProductName("红烧肉");
        productInfo.setProductPrice(new BigDecimal("38")) ;
        productInfo.setProductStock(100);
        productInfo.setProductDescription("贼他妈好吃");
        productInfo.setProductIcon("http:");
        productInfo.setCategoryType(6);
        sellerProductInfoRepository.save(productInfo);
    }

    @Test
    public void findByProductId(){
        ProductInfo productInfo = sellerProductInfoRepository.findByProductId("13dbcc1382c5421db58dee1e0adf0a15");
        System.out.println(productInfo);
    }
}