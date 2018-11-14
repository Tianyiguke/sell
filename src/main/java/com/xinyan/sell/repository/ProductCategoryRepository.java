package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 0014
 * ProductCategory数据访问层接口
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /**
     * 类目类型查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
