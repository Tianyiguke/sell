package com.xinyan.sell.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Administrator
 * 2018/11/19 15:54
 * JSON工具类
 */
public final class JSONUtil {
    public static ObjectMapper objectMapper;

    static {
        if(objectMapper == null){
            objectMapper = new ObjectMapper();
            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);
        }
    }

    /* JSON字符串转List */
    public static <T> T readValue(String jsonstr, TypeReference<T> valueTypeRef){
        try{
            return objectMapper.readValue(jsonstr,valueTypeRef);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
