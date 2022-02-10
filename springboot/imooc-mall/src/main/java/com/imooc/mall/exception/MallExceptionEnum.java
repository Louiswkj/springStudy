package com.imooc.mall.exception;

import lombok.Getter;

/**
 * @author liuliang
 * 2021/5/31
 */
@Getter
public enum MallExceptionEnum {
    /**
     * 用户名不能为空
     */
    NEED_USER_NAME(10001, "用户名不能为空"),
    NEED_USER_PASSWORD(10002, "用户密码不能为空"),
    PASSWORD_TOO_SHORT(10003, "密码长度不能少于8位"),
    USER_NAME_EXISTED(10004, "用户重名，请换个试试"),
    INSERT_FAILED(10005, "插入失败，请重试"),
    PASSWORD_ERROR(10006, "密码错误，请重试"),
    NEED_LOGIN(10007, "用户未登陆，请先登陆"),
    NEED_ADMIN_LOGIN(10008, "无管理员权限"),
    NAME_EXISTED(10009, "名称重复"),
    CREATE_FAILED(10010, "创建失败"),
    REQUEST_PARAM_ERROR(10011, "参数错误"),
    UPDATE_FAILED(10012, "更新失败"),
    DELETE_FAILED(10013, "删除失败"),


    SYSTEM_ERROR(20000, "系统异常"),
    ;

    private final Integer code;
    private final String message;

    MallExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
