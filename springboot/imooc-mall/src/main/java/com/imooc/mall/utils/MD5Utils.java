package com.imooc.mall.utils;

import com.imooc.mall.constant.MallConstant;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author liuliang
 * 2021/7/3
 * MD5工具
 */
public class MD5Utils {
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        //MD5加密，加盐值
        strValue = strValue + MallConstant.SLAT;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest((strValue).getBytes(StandardCharsets.UTF_8)));
    }
}
