package com.xinyan.sell.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 不夏
 * 2018/11/20 14:39
 * 微信网页授权
 */
@Slf4j
@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    /**
     * 1).用户同意授权，获取code
     * 2).通过code获取网页授权access_token
     * 3).刷新access_token(如果需要)
     * 4).拉取用户信息(scope 为 snsapi_userinfo)
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){

//        Cookie[] cookies = request.getCookies();

//        if (cookies != null){
//            for(Cookie cookie : cookies){
//                if (cookie.getName().equals("openid") && cookie.getValue() != null){
//                    log.info(returnUrl);
//                    log.info("以获取cookie"+cookie.getValue());
//                    return "redirect:"+returnUrl;
//                }
//            }
//        }

        //构造网页授权url，然后构成超链接让用户点击重定向的url地址
        String url = "http://s22n766577.51mypc.cn:44141/sell/wechat/userInfo";


        /**
         * oauth2buildAuthorizationUrl
         * url:用户授权的url，点击后会重定向并带上code 和 state 参数
         * scope:应用授权作用域
         *      snsapi_base:不弹出授权页面，直接跳转，只能获取用户openID
         *      snsapi_userinfo:弹出授权页面，可通过openid拿到用户昵称、性别、所在地
         *      且在未关注的情况下只要用户授权也能获取其信息
         * state:重定向会带上state参数
         */
        //redirectUrl:授权后重定向的回调连接地址
        //跳转回调redirect_uri,应当使用https链接来确保code的安全性
        String redirectUrl = null;
        try {
            redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url,
                    WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                    URLEncoder.encode(returnUrl,"utf-8"));
        }catch (UnsupportedEncodingException e){
            log.error("【微信网页授权】获取code, redirectUrl:{}",redirectUrl);
        }

        return  "redirect:" + redirectUrl;


    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl){


        WxMpUser wxMpUser = null;

        try{
            //当用户同意授权后，会回调所设置的url并把authorization code 传过来
            //然后用这个code获得access_token 其中包含用户的openid等信息
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            //获取用户基本信息
            wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken,null);
        }catch (WxErrorException e){
            log.error("【微信网页授权】{}", e);
        }

        //获取用户openId
        String openId = wxMpUser.getOpenId();
//        log.info("----------------"+openId);
//        Cookie cookie = new Cookie("openid",openId);
//        cookie.setMaxAge(120);
//        response.addCookie(cookie);
//        log.info("++++++++++++++++++="+returnUrl);

        return "redirect:"+returnUrl +"openid=" +openId;

    }
}
