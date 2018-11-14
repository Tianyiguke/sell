package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    /**
     * 测试通过id查找卖家信息表
     */
    @Test
    public void findonebyidTest(){
        SellerInfo seller = sellerInfoRepository.findOne(1);
        Assert.assertNotNull(seller);
    }

    /**
     *测试添加卖家信息
     */
    @Test
    public void addoneTest(){
        SellerInfo seller = new SellerInfo();
        seller.setId(2);
        seller.setOpenId("888");
        seller.setPassword("123456");
        seller.setUsername("sxx");
        SellerInfo save = sellerInfoRepository.save(seller);
        Assert.assertNotNull(seller);
    }

    /**
     *测试修改卖家信息
     */
    @Test
    public void updateoneTest(){
        SellerInfo seller = sellerInfoRepository.findOne(2);
        seller.setUsername("hhh");
        SellerInfo save = sellerInfoRepository.save(seller);
        Assert.assertNotNull(seller);
    }

    /**
     *测试通过id删除卖家信息
     */
    @Test
    public void deleteoneTest(){
    sellerInfoRepository.delete(2);
    }
}