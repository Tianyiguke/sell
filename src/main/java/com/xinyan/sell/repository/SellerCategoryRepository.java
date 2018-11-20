package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * sxx
 * 2018/11/16 0016
 */
@Repository
public interface SellerCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /**
     * 通过categoryId查询类目信息
     * @param categoryId
     * @return
     */
    public ProductCategory findByCategoryId(Integer categoryId);

    /**
     * 通过categoryyId删除类目信息
     * @param categoryyId
     */
    public void deleteByCategoryId(Integer categoryyId);
}
