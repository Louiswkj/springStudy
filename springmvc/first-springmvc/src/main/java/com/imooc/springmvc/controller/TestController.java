package com.imooc.springmvc.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author liuliang
 * 2022/2/9
 */
@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody //直接向响应输出字符串数据，不跳转页面
    public String test(@DateTimeFormat(pattern = "yyyy-MM-dd") Date createTime) {
        return "hello:" + createTime;
    }
}

