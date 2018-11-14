package com.xinyan.sell.utils;

import java.util.UUID;

/**
 * Administrator
 * 2018/11/14 0014
 * 工具类：主键：生成唯一key UUID
 */
public class KeyUtil {
    /**
     * 构造器私有化
     */
    private KeyUtil(){
    }

    /**
     * 主键生成策略UUID
     * @return
     */
    public static synchronized String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /***
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(KeyUtil.getUUID());
    }
}
