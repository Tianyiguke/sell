package com.xinyan.sell.service.impl;


import com.xinyan.sell.dto.ProductInfoDTO;
import com.xinyan.sell.enums.ProductStatus;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.SellerCategoryRepository;
import com.xinyan.sell.repository.SellerProductInfoRepository;
import com.xinyan.sell.service.SellerCategoryService;
import com.xinyan.sell.service.SellerProductInfoService;
import com.xinyan.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * sxx
 * 2018/11/15 0015
 */
@Service
public class SellerProductInfoServiceImple implements SellerProductInfoService {
    //===========================卖家端==============================

    @Autowired
    private SellerProductInfoRepository sellerProductInfoRepository;

    @Autowired
    private SellerCategoryRepository sellerCategoryRepository;
    /**
     * 分页查询所有商品
     * @param page
     * @return
     */
    @Override
    public Page<ProductInfoDTO> findAllPage(Pageable page) {

        PageRequest pageRequest = new PageRequest(page.getPageNumber(),page.getPageSize());
        Page<ProductInfo> sellerProductInfoPage = sellerProductInfoRepository.findAll(pageRequest);
        List<ProductCategory> categoryList = sellerCategoryRepository.findAll();

        List<ProductInfoDTO> productInfoDTOList = new ArrayList<>();

        for(ProductInfo productInfo : sellerProductInfoPage){
            ProductInfoDTO productInfoDTO = new ProductInfoDTO();
            BeanUtils.copyProperties(productInfo,productInfoDTO);

            if (productInfoDTO.getProductId().equals(productInfo.getProductId())){
                int productStatus = productInfo.getProductStatus();
                if (productStatus == ProductStatus.UP.getCode()){
                    productInfoDTO.setProductStatusMsg(ProductStatus.UP.getMessage());
                }else {
                    productInfoDTO.setProductStatusMsg(ProductStatus.DOWN.getMessage());
                }
            }


            for (ProductCategory productCategory : categoryList){
                if (productCategory.getCategoryType() == productInfoDTO.getCategoryType()) {
                    productInfoDTO.setCategoryTypeMsg(productCategory.getCategoryName());
                }
            }


            productInfoDTOList.add(productInfoDTO);
        }

        Page<ProductInfoDTO> productInfoDTOPage = new PageImpl<>(productInfoDTOList, page, sellerProductInfoPage.getTotalElements());

        return productInfoDTOPage;
    }

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<ProductInfo> findAll() {
        return sellerProductInfoRepository.findAll();
    }


    /**
     * 新增商品
     * @param productInfo
     */
    @Override
    public void save(ProductInfo productInfo) {
        productInfo.setProductId(KeyUtil.getUUID());
        sellerProductInfoRepository.save(productInfo);
    }

    /**
     * 通过productId查询商品 并修改商品状态
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findByProductIdAndUpdateStatus(String productId) {
        ProductInfo productInfo = sellerProductInfoRepository.findByProductId(productId);
        return productInfo;
    }

    /**
     * 通过productId查询商品
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findByProductId(String productId) {
        ProductInfo productInfo = sellerProductInfoRepository.findByProductId(productId);
        return productInfo;
    }


    /**
     * 保存商品信息
     * @param productInfo
     */
    @Override
    public void saveUpdateProduct(ProductInfo productInfo) {
        sellerProductInfoRepository.save(productInfo);
    }


}
