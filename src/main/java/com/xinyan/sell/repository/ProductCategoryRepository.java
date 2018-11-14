package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Administrator
 * 2018/11/14 0014
 * ProductCategory数据访问层接口
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    /**
     * 根据类目名称查询
     */
    public ProductCategory findByCategoryNameLike(String string);
}
