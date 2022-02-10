package com.imooc.mall.service;

import com.imooc.mall.exception.MallException;
import com.imooc.mall.model.pojo.MallUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author liuliang
 * 2021/7/3
 */
public interface MallUserService extends IService<MallUser> {
    /**
     * 根据用户名和密码注册
     *
     * @param userName 用户名
     * @param password 密码
     * @throws MallException 异常
     */
    void register(String userName, String password) throws MallException;

    /**
     * 根据用户名密码登陆，并返回登陆信息
     *
     * @param userName 用户名
     * @param password 密码
     * @return 信息
     */
    MallUser login(String userName, String password);

    /**
     * 验证是否是管理员
     *
     * @param user 用户
     * @return boolean值
     */
    Boolean checkAdmin(MallUser user);

}


