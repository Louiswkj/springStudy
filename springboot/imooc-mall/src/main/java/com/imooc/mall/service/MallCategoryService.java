package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.model.pojo.MallCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.mall.model.vo.CategoryVO;
import com.imooc.mall.param.CategoryAddParam;
import com.imooc.mall.param.CategoryUpdateParam;

import java.util.List;

/**
 * @author liuliang
 * 2021/7/3
 */
public interface MallCategoryService extends IService<MallCategory> {

    /**
     * 创建分类
     *
     * @param categoryAddParam 参数
     */
    void add(CategoryAddParam categoryAddParam);

    /**
     * 根据分类名称查找数据
     *
     * @param name 分类名称
     * @return 内容
     */
    MallCategory getOneByName(String name);

    /**
     * 修改分类
     *
     * @param categoryUpdateParam 参数
     */
    void edit(CategoryUpdateParam categoryUpdateParam);

    /**
     * 删除一条记录
     *
     * @param id id
     */
    void delete(Integer id);

    /**
     * 分页分类
     *
     * @param pageNum  分页
     * @param pageSize 一页数据
     * @return page
     */
    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    /**
     * 返回无限分类
     *
     * @return list
     */
    List<CategoryVO> listForCustomer();
}


