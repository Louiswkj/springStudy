package com.imooc.mall.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author liuliang
 * 2021/7/3
 */

/**
 * 分类表
 */
@ApiModel(value = "com-imooc-mall-model-pojo-MallCategory")
@Data
@TableName(value = "mall_category")
public class MallCategory implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 分类目录名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "分类目录名称")
    private String name;

    /**
     * 分类目录级别1-1级2-级
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value = "分类目录级别1-1级2-级")
    private Integer type;

    /**
     * 父级 上一级目录
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value = "父级 上一级目录")
    private Integer parentId;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    @ApiModelProperty(value = "排序")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}