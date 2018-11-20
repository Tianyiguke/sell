package com.xinyan.sell.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.xinyan.sell.enums.ProductStatus;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.SellerProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Administrator
 * 2018/11/15 0015
 */
@RequestMapping("/seller/product")
@Controller
public class SellerProductController {

    @Autowired
    private SellerProductInfoService sellerProductInfoService;

    /**
     * 跳转到商品列表目录
     * @return
     */
    @RequestMapping("/list")
    public String sellerProduct( @RequestParam(value = "page" ,defaultValue = "1") Integer page , Model model){

        PageRequest pageRequest = new PageRequest(page-1,5);
        Page<ProductInfo> productInfoPage = sellerProductInfoService.findAllPage(pageRequest);
        model.addAttribute("productInfoPage",productInfoPage);

        return "product/list";
    }


    /**
     * 跳转到增加商品页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String sellerProductToAdd(){
        return "product/add";
    }


    /**
     * 增加商品
     * @param productInfo
     * @return
     */
    @PostMapping("/add")
    public String sellerProductAdd(ProductInfo productInfo){
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
        }else {
            productInfo.setProductStatus(ProductStatus.UP.getCode());
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

        sellerProductInfoService.saveUpdateProduct(productInfo);

        return "redirect:/seller/product/list";
    }

}
