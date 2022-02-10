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
 * 商品表
 */
@ApiModel(value = "com-imooc-mall-model-pojo-MallProduct")
@Data
@TableName(value = "mall_product")
public class MallProduct implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 商品名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "商品名称")
    private String name;

    /**
     * 商品图片
     */
    @TableField(value = "image")
    @ApiModelProperty(value = "商品图片")
    private String image;

    /**
     * 商品详情
     */
    @TableField(value = "detail")
    @ApiModelProperty(value = "商品详情")
    private String detail;

    /**
     * 分类id
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value = "分类id")
    private Integer categoryId;

    /**
     * 价格（单位分）
     */
    @TableField(value = "price")
    @ApiModelProperty(value = "价格（单位分）")
    private Integer price;

    /**
     * 商品库存
     */
    @TableField(value = "stock")
    @ApiModelProperty(value = "商品库存")
    private Integer stock;

    /**
     * 状态0下架1上架
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "状态0下架1上架")
    private Integer status;

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