package com.xinyan.sell.controller;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.SellerCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * sxx
 * 2018/11/16 0016
 */
@RequestMapping("/seller/category")
@Controller
public class SellerCategoryController {

    @Autowired
    private SellerCategoryService sellerCategoryService;

    /**
     * 跳转到商品类目列表页面
     * @return
     */
    @RequestMapping("/list")
    public String sellerCategory(Model model){
        List<ProductCategory> sellerCategorytList = sellerCategoryService.findAll();
        model.addAttribute("sellerCategorytList",sellerCategorytList);
        return "category/list";
    }


    /**
     * 跳转到增加商品类目页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String sellerProductCategoryToAdd(){
        return "category/add";
    }


    /**
     * 增加类目
     * @param productCategory
     * @return
     */
    @PostMapping("/add")
    public String sellerProductAdd(ProductCategory productCategory){
        sellerCategoryService.save(productCategory);
        return "redirect:/seller/category/list";
    }


    /**
     * 跳转到修改商品类目页面
     * @param
     * @return
     */
    @RequestMapping("/toUpdate")
    public String sellerProductToUpdateCategory(@RequestParam("categoryId")int categoryId, Model model){
        ProductCategory productCategory = sellerCategoryService.findProductCategoryByCategoryId(categoryId);
        model.addAttribute("productCategory",productCategory);

        return "category/update";
    }

    /**
     * 修改商品类目页面
     * @param productCategory
     * @return
     */
    @RequestMapping("/update")
    public String sellerProductUpdateCategoryByCategoryId(ProductCategory productCategory){

        sellerCategoryService.save(productCategory);

        return "redirect:/seller/category/list";
    }

    @Transactional
    @RequestMapping("/delete")
    public String deleteProductUpdateCategoryByCategoryId(@RequestParam("categoryId")int categoryId){

        sellerCategoryService.deleteProductCategoryByCategoryId(categoryId);

        return "redirect:/seller/category/list";
    }

}
