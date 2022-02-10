package com.imooc.mall.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author czw
 * @date 2021/3/2 14:05
 */
public class HttpContextUtils {

    public static HttpServletRequest getHttpServletRequest() {
        try {
            if (RequestContextHolder.getRequestAttributes() != null) {
                return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static HttpServletResponse getHttpServletResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getResponse();
    }

    public static String getDomain() {
        HttpServletRequest request = getHttpServletRequest();
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    }

    public static String getOrigin() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getHeader("Origin");
    }
}
