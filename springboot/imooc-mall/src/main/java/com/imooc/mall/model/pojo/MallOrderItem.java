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
 * 订单详情
 */
@ApiModel(value = "com-imooc-mall-model-pojo-MallOrderItem")
@Data
@TableName(value = "mall_order_item")
public class MallOrderItem implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 订单号
     */
    @TableField(value = "order_no")
    @ApiModelProperty(value = "订单号")
    private String orderNo;

    /**
     * 商品id
     */
    @TableField(value = "product_id")
    @ApiModelProperty(value = "商品id")
    private Integer productId;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    @ApiModelProperty(value = "商品名称")
    private String productName;

    /**
     * 商品图片
     */
    @TableField(value = "product_image")
    @ApiModelProperty(value = "商品图片")
    private String productImage;

    /**
     * 商品单价
     */
    @TableField(value = "unit_price")
    @ApiModelProperty(value = "商品单价")
    private Integer unitPrice;

    /**
     * 数量
     */
    @TableField(value = "quantity")
    @ApiModelProperty(value = "数量")
    private Integer quantity;

    /**
     * 商品总价
     */
    @TableField(value = "total_price")
    @ApiModelProperty(value = "商品总价")
    private Integer totalPrice;

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