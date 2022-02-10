package com.imooc.mall.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 分类表
 *
 * @author liuliang
 * 2021/7/3
 */
@ApiModel(value = "com-imooc-mall-model-pojo-MallCategory")
@Data
@TableName(value = "mall_category")
public class CategoryVO implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 分类目录名称
     */
    @ApiModelProperty(value = "分类目录名称")
    private String name;

    /**
     * 分类目录级别1-1级2-级
     */
    @ApiModelProperty(value = "分类目录级别1-1级2-级")
    private Integer type;

    /**
     * 父级 上一级目录
     */
    @ApiModelProperty(value = "父级 上一级目录")
    private Integer parentId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "目录下级")
    List<CategoryVO> childCategory = new ArrayList<>();

    private static final long serialVersionUID = 1L;
}