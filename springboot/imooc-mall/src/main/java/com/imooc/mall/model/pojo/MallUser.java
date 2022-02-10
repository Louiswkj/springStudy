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
 * 用户表
 */
@ApiModel(value = "com-imooc-mall-model-pojo-MallUser")
@Data
@TableName(value = "mall_user")
public class MallUser implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "姓名")
    private String username;

    /**
     * 密码MD5加密
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value = "密码MD5加密")
    private String password;

    /**
     * 个性签名
     */
    @TableField(value = "`describe`")
    @ApiModelProperty(value = "个性签名")
    private String describe;

    /**
     * 角色1-普通用户2-管理员
     */
    @TableField(value = "`role`")
    @ApiModelProperty(value = "角色1-普通用户2-管理员")
    private Integer role;

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