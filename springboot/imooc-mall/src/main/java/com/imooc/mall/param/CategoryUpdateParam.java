package com.imooc.mall.param;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author liuliang
 * 2021/6/16
 */
@Data
public class CategoryUpdateParam {
    @NotNull(message = "主键id不能为空")
    private Integer id;
    @NotNull(message = "名称不能为空")
    @Size(min = 2, max = 5)
    private String name;
    @NotNull(message = "类型不能为空")
    @Max(3)
    private Integer type;
    private Integer parentId;
    @NotNull(message = "排序不能为空")
    private Integer orderNum;
}
