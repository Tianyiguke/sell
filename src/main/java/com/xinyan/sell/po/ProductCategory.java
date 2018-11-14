package com.xinyan.sell.po;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PO持久化数据对象类
 * ProductCategory
 */

@Data
@Table(name="product_category")
@Entity
@DynamicUpdate
public class ProductCategory {

    /**
     * 类目ID
     */
    @GeneratedValue
    @Id
    private  Integer categoryId;
    /**
     * 类目名称
     */
    private  String categoryName;
    /**
     * 类目编号
     */
    private  Integer categoryType;
}
