package com.xinyan.sell.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.xinyan.sell.common.SellException;
import com.xinyan.sell.dto.ProductInfoDTO;
import com.xinyan.sell.enums.ProductStatus;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.SellerCategoryService;
import com.xinyan.sell.service.SellerProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Administrator
 * 2018/11/15 0015
 */
@Slf4j
@RequestMapping("/seller/product")
@Controller
public class SellerProductController {

    @Autowired
    private SellerProductInfoService sellerProductInfoService;

    @Autowired
    private SellerCategoryService sellerCategoryService;

    /**
     * 跳转到商品列表目录(分页查询商品列表)
     * @return
     */
    @RequestMapping("/list")
    public String sellerProduct( @RequestParam(value = "page" ,required = false, defaultValue = "1")Integer page ,
                                 @RequestParam(value = "size" ,required = false, defaultValue = "5")Integer size ,
                                  Model model){

        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<ProductInfoDTO> productInfoDTOPage = sellerProductInfoService.findAllPage(pageRequest);


        model.addAttribute("productInfoPage",productInfoDTOPage);

        return "product/list";
    }


    /**
     * 跳转到增加商品页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String sellerProductToAdd(Model model){
        List<ProductCategory> productCategoryList = sellerCategoryService.findAll();
        model.addAttribute("productCategoryList",productCategoryList);
        return "product/add";
    }


    /**
     * 增加商品
     * @param productInfo
     * @return
     */
    @PostMapping("/add")
    public String sellerProductAdd(@Valid ProductInfo productInfo, BindingResult bindingResult){

        if (productInfo == null){
            log.error("【增加商品参数有误】",productInfo);
            throw new SellException(ResultStatus.PRODUCT_ADD_MSG_ERROR);
        }
        sellerProductInfoService.save(productInfo);
        return "redirect:/seller/product/list";
    }

    /**
     * 修改商品状态
     * @param productId
     * @return
     */
    @Transactional
    @GetMapping("/UpdateStatus")
    public String sellerProductUpdateStatus(@RequestParam("productId")String productId){

        ProductInfo productInfo = sellerProductInfoService.findByProductIdAndUpdateStatus(productId);


        if (productInfo.getProductStatus().equals(ProductStatus.UP.getCode())){
            productInfo.setProductStatus(ProductStatus.DOWN.getCode());
            if (productInfo.getProductStatus() != ProductStatus.DOWN.getCode()){
                log.error("【修改商品下架状态失败】",productInfo.getProductStatus());
                throw new SellException(ResultStatus.PRODUCT_DOWN_MSG_ERROR);
            }
        }else {
            productInfo.setProductStatus(ProductStatus.UP.getCode());
            if (productInfo.getProductStatus() != ProductStatus.UP.getCode()){
                log.error("【修改商品上架状态失败】",productInfo.getProductStatus());
                throw new SellException(ResultStatus.PRODUCT_UP_MSG_ERROR);
            }
        }

        sellerProductInfoService.saveUpdateProduct(productInfo);

        return "redirect:/seller/product/list";
    }

    /**
     * 跳转到修改商品信息页面
     * @param productId
     * @param model
     * @return
     */
    @RequestMapping("/toUpdateProduct")
    public String sellerProductToUpdateProduct(@RequestParam("productId")String productId , Model model){

        ProductInfo productInfo = sellerProductInfoService.findByProductId(productId);

        if (productInfo == null){
            log.error("【获取商品修改信息有误】",productInfo);
            throw new SellException(ResultStatus.PRODUCT_GET_MSG_ERROR);
        }

        List<ProductCategory> categoryList = sellerCategoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("productInfo",productInfo);
        return "product/update";
    }

    /**
     * 修改商品信息
     * @param productInfo
     * @return
     */
    @PostMapping("/updateProduct")
    public String sellerProductUpdateProduct(ProductInfo productInfo){

        if (productInfo == null){
            log.error("【修改商品状态失败】",productInfo);
            throw new SellException(ResultStatus.PRODUCT_GET_AFTER_MSG_ERROR);
        }
        sellerProductInfoService.saveUpdateProduct(productInfo);

        return "redirect:/seller/product/list";
    }

}
