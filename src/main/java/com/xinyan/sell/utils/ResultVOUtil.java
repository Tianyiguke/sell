package com.xinyan.sell.utils;

import com.xinyan.sell.vo.ProductVO;
import com.xinyan.sell.vo.ResultVO;

import java.util.List;

/**
 * 不夏
 * 2018/11/15 19:28
 * 买家端商品列表返回json数据转换工具
 */
public class ResultVOUtil {


    public static ResultVO success (Object obj){

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(obj);
        return resultVO;
    }

}
