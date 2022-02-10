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
 * 订单
 */
@ApiModel(value = "com-imooc-mall-model-pojo-MallOrder")
@Data
@TableName(value = "mall_order")
public class MallOrder implements Serializable {
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
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    /**
     * 订单总价格
     */
    @TableField(value = "total_price")
    @ApiModelProperty(value = "订单总价格")
    private Integer totalPrice;

    /**
     * 收货地址id
     */
    @TableField(value = "receiver_id")
    @ApiModelProperty(value = "收货地址id")
    private Integer receiverId;

    /**
     * 订单状态
     */
    @TableField(value = "order_status")
    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    /**
     * 运费
     */
    @TableField(value = "postage")
    @ApiModelProperty(value = "运费")
    private Integer postage;

    /**
     * 支付类型 1-在线支付
     */
    @TableField(value = "payment_type")
    @ApiModelProperty(value = "支付类型 1-在线支付")
    private Integer paymentType;

    /**
     * 发货时间
     */
    @TableField(value = "delivery_time")
    @ApiModelProperty(value = "发货时间")
    private Date deliveryTime;

    /**
     * 支付时间
     */
    @TableField(value = "pay_time")
    @ApiModelProperty(value = "支付时间")
    private Date payTime;

    /**
     * 交易完成时间
     */
    @TableField(value = "end_time")
    @ApiModelProperty(value = "交易完成时间")
    private Date endTime;

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