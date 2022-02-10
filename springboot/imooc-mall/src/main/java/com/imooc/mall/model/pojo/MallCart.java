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
@ApiModel(value = "com-imooc-mall-model-pojo-MallCart")
@Data
@TableName(value = "mall_cart")
public class MallCart implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 商品id
     */
    @TableField(value = "product_id")
    @ApiModelProperty(value = "商品id")
    private Integer productId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    /**
     * 商品数量
     */
    @TableField(value = "quantity")
    @ApiModelProperty(value = "商品数量")
    private Integer quantity;

    /**
     * 是否勾选（0未勾选1、勾选）
     */
    @TableField(value = "selected")
    @ApiModelProperty(value = "是否勾选（0未勾选1、勾选）")
    private Integer selected;

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