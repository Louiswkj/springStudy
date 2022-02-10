package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.constant.MallConstant;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.model.pojo.MallCategory;
import com.imooc.mall.model.pojo.MallUser;
import com.imooc.mall.model.vo.CategoryVO;
import com.imooc.mall.param.CategoryAddParam;
import com.imooc.mall.param.CategoryUpdateParam;
import com.imooc.mall.service.MallCategoryService;
import com.imooc.mall.service.MallUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * @author liuliang
 * 2021/7/3
 */
@RestController
public class CategoryController {
    @Autowired
    private MallUserService userService;
    @Autowired
    private MallCategoryService categoryService;

    /**
     * 后台添加目录
     *
     * @param session          session
     * @param categoryAddParam 目录参数
     * @return ApiRestResponse
     */
    @ApiOperation("后台添加目录")
    @PostMapping("admin/category/add")
    public ApiRestResponse addCategory(HttpSession session, @Valid @RequestBody CategoryAddParam categoryAddParam) {
        MallUser currentUser = (MallUser) session.getAttribute(MallConstant.MALL_USER);
        if (currentUser == null) {
            throw new MallException(MallExceptionEnum.NEED_LOGIN);
        }
        //校验是不是管理员
        Boolean isAdmin = userService.checkAdmin(currentUser);
        if (isAdmin) {
            //是管理员执行操作
            categoryService.add(categoryAddParam);
        } else {
            throw new MallException(MallExceptionEnum.NEED_ADMIN_LOGIN);
        }
        return ApiRestResponse.success();
    }

    @ApiOperation("后台修改目录")
    @PostMapping("admin/category/update")
    public ApiRestResponse updateCategory(HttpSession session, @Valid @RequestBody CategoryUpdateParam categoryUpdateParam) {
        MallUser currentUser = (MallUser) session.getAttribute(MallConstant.MALL_USER);
        if (currentUser == null) {
            throw new MallException(MallExceptionEnum.NEED_LOGIN);
        }
        //校验是不是管理员
        Boolean isAdmin = userService.checkAdmin(currentUser);
        if (isAdmin) {
            //是管理员执行操作
            categoryService.edit(categoryUpdateParam);
        } else {
            throw new MallException(MallExceptionEnum.NEED_ADMIN_LOGIN);
        }
        return ApiRestResponse.success();
    }

    @ApiOperation("后台删除目录")
    @PostMapping("admin/category/delete")
    public ApiRestResponse deleteCategory(@RequestParam Integer id) {
        categoryService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台目录列表")
    @GetMapping("admin/category/list")
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo pageInfo = categoryService.listForAdmin(pageNum,pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("前台目录列表")
    @GetMapping("category/list")
    public ApiRestResponse listCategoryForCustomer(){
        List<CategoryVO> categoryVOList = categoryService.listForCustomer();
        return ApiRestResponse.success(categoryVOList);
    }


}

