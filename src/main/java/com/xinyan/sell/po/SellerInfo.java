package com.xinyan.sell.po;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Administrator
 * 2018/11/14 0014
 * 卖家PO持久化数据对象类
 */

@Data
@Entity
@DynamicUpdate
public class SellerInfo {

    /**  卖家id */
    @Id
    private Integer id;

    /**  卖家用户名*/
    private String username;

    /**  卖家密码 */
    private String password;

    /**  微信openid */
    private String openId;
}
