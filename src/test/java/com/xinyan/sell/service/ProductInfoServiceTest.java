package com.xinyan.sell.service;

import com.xinyan.sell.enums.ProductStatus;
import com.xinyan.sell.po.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceTest {

    @Autowired
    private ProductInfoService productInfoService;

    //查询单个
    @Test
    public void findOne() {
        ProductInfo productInfoOne = productInfoService.findOne("3c41f83563e946d4952ddfd09de6d9bc");
        Assert.assertNotNull(productInfoOne);
    }

    //；商品列表查询
    @Test
    public void findAll1() {
        List<ProductInfo> productInfoList = productInfoService.findAll();
        Assert.assertNotNull("未找到商品",productInfoList);
    }

    //根据商品状态查询
    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productInfoService.findByProductStatus(ProductStatus.UP.getCode());
        Assert.assertNotNull(productInfos);
    }

    //分页查询
    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> infoPage = productInfoService.findAll(pageRequest);
        Assert.assertNotEquals(0,infoPage.getTotalElements());
    }
}