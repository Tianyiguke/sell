package com.xinyan.sell.controller;

import com.xinyan.sell.common.SellException;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.SellerCategoryService;
import com.xinyan.sell.vo.OrderDTOVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * sxx
 * 2018/11/16 0016
 */
@Slf4j
@RequestMapping("/seller/category")
@Controller
public class SellerCategoryController {

    @Autowired
    private SellerCategoryService sellerCategoryService;

    /**
     * 跳转到商品类目列表页面(分页查询商品类目列表)
     * @return
     */
    @RequestMapping("/list")
    public String sellerCategory(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
                                 Map<String, Object> map){
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductCategory> productCategoryPage = sellerCategoryService.findAll(pageRequest);
        map.put("productCategoryPage",productCategoryPage);
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
        if (productCategory == null){
            log.error("【增加类目失败】",productCategory);
            throw new SellException(ResultStatus.CATEGORY_ADD_MSG_ERROR);
        }
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
        if (productCategory == null){
            log.error("【获取类目信息有误】",productCategory);
            throw new SellException(ResultStatus.CATEGORY_GET_MSG_ERROR);
        }
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

        if (productCategory == null){
            log.error("【获取类目修改后参数失败】",productCategory);
            throw new SellException(ResultStatus.PRODUCT_GET_AFTER_MSG_ERROR);
        }

        sellerCategoryService.save(productCategory);

        return "redirect:/seller/category/list";
    }


    /**
     * 删除类目
     * @param categoryId
     * @return
     */
    @Transactional
    @RequestMapping("/delete")
    public String deleteProductUpdateCategoryByCategoryId(@RequestParam("categoryId")int categoryId){

        sellerCategoryService.deleteProductCategoryByCategoryId(categoryId);

        if (sellerCategoryService.findProductCategoryByCategoryId(categoryId) != null){
            log.error("【删除类目失败】",categoryId);
            throw new SellException(ResultStatus.CATEGORY_GET_MSG_ERROR);
        }

        return "redirect:/seller/category/list";
    }

}
