package com.imooc.springmvc.controller;

import com.imooc.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuliang
 * 2022/2/9
 */
@Controller
@RequestMapping("/fm")
public class FreemarkerController {
    @GetMapping("/test")
    public ModelAndView testFreemarker() {
        ModelAndView modelAndView = new ModelAndView("/test");
        User user = new User();
        user.setUsername("老张");
        user.setAge(18);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
