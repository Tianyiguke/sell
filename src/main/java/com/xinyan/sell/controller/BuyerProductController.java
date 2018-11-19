package com.xinyan.sell.controller;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductCategoryService;
import com.xinyan.sell.service.ProductInfoService;
import com.xinyan.sell.utils.ResultVOUtil;
import com.xinyan.sell.vo.ProductInfoVO;
import com.xinyan.sell.vo.ProductVO;
import com.xinyan.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 不夏
 * 2018/11/14 19:49
 * 买家商品列表 Controller
 */
@RequestMapping("/buyer/product")
@RestController
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 买家信息表
     * @return
     */
    @RequestMapping("/list")
    public ResultVO list(){

        //商品信息(上架)
        List<ProductInfo> productInfoList = productInfoService.findByProductStatus(0);

        //商品类目

        //传统实现
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for(ProductInfo productInfo : productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        //JDK 1.8 可用
        List<Integer> categoryTypeList = productInfoList.stream()
                  .map(e ->e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = productCategoryService.findAll(categoryTypeList);
        //拼装数据
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            //BeanUtils 进行属性拷贝(两个对象之间有相同属性)
            BeanUtils.copyProperties(productCategory,productVO);

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

}
