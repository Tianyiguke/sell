package com.xinyan.sell.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 不夏
 * 2018/11/19 14:42
 * 微信网页授权
 */
@Slf4j
@RequestMapping("/wechat")
@Controller
public class WechatController {

//    @Autowired
//    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){

//        String url = "http://"

        return null;
    }

}
