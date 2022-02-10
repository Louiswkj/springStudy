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
 * 用户收货地址表
 */
@ApiModel(value = "com-imooc-mall-model-pojo-MallReceiver")
@Data
@TableName(value = "mall_receiver")
public class MallReceiver implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 地址
     */
    @TableField(value = "address")
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 默认地址1-默认地址0非默认地址
     */
    @TableField(value = "is_default")
    @ApiModelProperty(value = "默认地址1-默认地址0非默认地址")
    private Integer isDefault;

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