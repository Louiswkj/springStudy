package com.imooc.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.imooc.mall.constant.RoleConstant;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.mall.model.dao.MallUserMapper;
import com.imooc.mall.model.pojo.MallUser;
import com.imooc.mall.service.MallUserService;

/**
 * @author liuliang
 * 2021/7/3
 */
@Service
public class MallUserServiceImpl extends ServiceImpl<MallUserMapper, MallUser> implements MallUserService {
    @Autowired
    private MallUserMapper userMapper;

    @Override
    public void register(String userName, String password) throws MallException {
        //查看 用户名是否存在，不允许重名
        MallUser result = getOne(new LambdaQueryWrapper<MallUser>().eq(MallUser::getUsername, userName).last("limit 1"));
        if (result != null) {
            throw new MallException(MallExceptionEnum.USER_NAME_EXISTED);
        }

        MallUser user = new MallUser();
        user.setUsername(userName);
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        boolean flag = save(user);
        if (!flag) {
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }

    @Override
    public MallUser login(String userName, String password) {
        String md5Password = null;
        try {
            md5Password = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        MallUser user = getOne(new LambdaQueryWrapper<MallUser>().eq(MallUser::getPassword, md5Password).eq(MallUser::getUsername, userName));
        if (user == null) {
            throw new MallException(MallExceptionEnum.PASSWORD_ERROR);
        }
        return user;
    }

    @Override
    public Boolean checkAdmin(MallUser user) {
        return user != null && user.getRole() != null && user.getRole().equals(RoleConstant.ADMIN_ROLE);
    }
}


