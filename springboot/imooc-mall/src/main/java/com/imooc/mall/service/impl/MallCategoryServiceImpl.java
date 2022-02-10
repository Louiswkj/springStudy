package com.imooc.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.model.vo.CategoryVO;
import com.imooc.mall.param.CategoryAddParam;
import com.imooc.mall.param.CategoryUpdateParam;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.mall.model.pojo.MallCategory;
import com.imooc.mall.model.dao.MallCategoryMapper;
import com.imooc.mall.service.MallCategoryService;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliang
 * 2021/7/3
 */
@Service
public class MallCategoryServiceImpl extends ServiceImpl<MallCategoryMapper, MallCategory> implements MallCategoryService {
    @Override
    public void add(CategoryAddParam categoryAddParam) {
        MallCategory one = getOneByName(categoryAddParam.getName());
        if (one != null) {
            throw new MallException(MallExceptionEnum.NAME_EXISTED);
        }
        MallCategory category = new MallCategory();
        BeanUtils.copyProperties(categoryAddParam, category);
        boolean saveResult = save(category);
        if (!saveResult) {
            throw new MallException(MallExceptionEnum.CREATE_FAILED);
        }
    }

    @Override
    public MallCategory getOneByName(String name) {
        return getOne(new LambdaQueryWrapper<MallCategory>().eq(MallCategory::getName, name).last("limit 1"));
    }

    @Override
    public void edit(CategoryUpdateParam categoryUpdateParam) {
        MallCategory one = getOne(new LambdaQueryWrapper<MallCategory>()
                .eq(MallCategory::getName, categoryUpdateParam.getName())
                .ne(MallCategory::getId, categoryUpdateParam.getId())
                .last("limit 1"));
        if (one != null) {
            throw new MallException(MallExceptionEnum.NAME_EXISTED);
        }
        MallCategory category = new MallCategory();
        BeanUtils.copyProperties(categoryUpdateParam, category);
        boolean saveResult = updateById(category);
        if (!saveResult) {
            throw new MallException(MallExceptionEnum.CREATE_FAILED);
        }
    }

    @Override
    public void delete(Integer id) {
        MallCategory categoryOld = getById(id);
        if (categoryOld == null) {
            throw new MallException(MallExceptionEnum.DELETE_FAILED);
        }
        boolean b = removeById(id);
        if (!b) {
            throw new MallException(MallExceptionEnum.UPDATE_FAILED);
        }
    }

    @Override
    public PageInfo listForAdmin(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, "type,order_num");
        List<MallCategory> categoryList = list();
        return new PageInfo(categoryList);
    }

    @Override
    @Cacheable(value = "listForCustomer")
    public List<CategoryVO> listForCustomer() {
        List<CategoryVO> categoryVOList = new ArrayList<>();
        recursivelyFindCategories(categoryVOList, 0);
        return categoryVOList;
    }

    /**
     * 返回无限分类
     *
     * @param categoryVOList 列表
     * @param parentId       父级id
     * @return list
     */
    private void recursivelyFindCategories(List<CategoryVO> categoryVOList, Integer parentId) {
        List<MallCategory> categoryList = list(new LambdaQueryWrapper<MallCategory>().eq(MallCategory::getParentId, parentId));
        System.out.println("categoryList=" + categoryList);
        if (!CollectionUtils.isEmpty(categoryList)) {
            categoryList.forEach(category -> {
                System.out.println("category=" + category);
                CategoryVO categoryVO = new CategoryVO();
                BeanUtils.copyProperties(category, categoryVO);
                categoryVOList.add(categoryVO);
                recursivelyFindCategories(categoryVO.getChildCategory(), categoryVO.getId());
            });
        }
    }

}


