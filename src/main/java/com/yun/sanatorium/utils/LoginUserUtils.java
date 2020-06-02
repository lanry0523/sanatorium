package com.yun.sanatorium.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class LoginUserUtils {

    /**
     * 获取当前登陆用户信息
     *
     * @param request
     * @return 如未获取到用户信息返回NULL
     */
    public static JSONObject getCurrLoginUser(HttpServletRequest request) {
        String userStr = request.getHeader("user");
        JSONObject user = null;
        if (StringUtils.isNotBlank(userStr)) {
            try {
                user = JSONObject.parseObject(URLDecoder.decode(userStr, "UTF-8"));//解码
            } catch (UnsupportedEncodingException var4) {
                var4.printStackTrace();
            }
        }

        return user;
    }

    /**
     * 获取当前登陆用户ID
     *
     * @param request
     * @return 如未获取用户ID返回NULL
     */
    public static String getCurrLoginUserId(HttpServletRequest request) {
        String currLoginUserId = null;
        JSONObject currLoginUser = getCurrLoginUser(request);

        if (null != currLoginUser) currLoginUserId = currLoginUser.getString("id");
        return currLoginUserId;
    }
}

