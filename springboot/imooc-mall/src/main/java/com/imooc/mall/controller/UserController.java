package com.imooc.mall.controller;

import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.constant.MallConstant;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.model.pojo.MallUser;
import com.imooc.mall.service.MallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author liuliang
 * 2021/7/3
 * 描述 用户控制器
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private MallUserService mallUserService;

    @PostMapping("/register")
    public ApiRestResponse register(@RequestParam("userName") String userName,
                                    @RequestParam("password") String password) throws MallException {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_PASSWORD);
        }
        //密码长度不能少于8位
        if (password.length() < 8) {
            return ApiRestResponse.error(MallExceptionEnum.PASSWORD_TOO_SHORT);
        }
        mallUserService.register(userName, password);
        return ApiRestResponse.success();
    }

    @PostMapping("/login")
    public ApiRestResponse login(@RequestParam("userName") String userName,
                                 @RequestParam("password") String password,
                                 HttpSession session) {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_PASSWORD);
        }
        //不返回密码
        MallUser user = mallUserService.login(userName, password);
        user.setPassword(null);
        session.setAttribute(MallConstant.MALL_USER, user);
        return ApiRestResponse.success(user);
    }

    @PostMapping("/update")
    public ApiRestResponse updateUserInfo(HttpSession session, @RequestParam String describe) {
        MallUser currentUser = (MallUser) session.getAttribute(MallConstant.MALL_USER);
        if (currentUser == null) {
            throw new MallException(MallExceptionEnum.NEED_LOGIN);
        }

        MallUser user = new MallUser();
        user.setDescribe(describe);
        user.setId(currentUser.getId());
        mallUserService.updateById(user);
        return ApiRestResponse.success();
    }

    @GetMapping("/logout")
    public ApiRestResponse logout(HttpSession session) {
        session.removeAttribute(MallConstant.MALL_USER);
        return ApiRestResponse.success();
    }

    @PostMapping("/admin-login")
    public ApiRestResponse adminLogin(@RequestParam("userName") String userName,
                                      @RequestParam("password") String password,
                                      HttpSession session) {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_PASSWORD);
        }
        //不返回密码
        MallUser user = mallUserService.login(userName, password);
        //校验是否是管理员
        if (mallUserService.checkAdmin(user)) {
            user.setPassword(null);
            session.setAttribute(MallConstant.MALL_USER, user);
            return ApiRestResponse.success(user);
        } else {
            return ApiRestResponse.error(MallExceptionEnum.NEED_ADMIN_LOGIN);
        }

    }
}
