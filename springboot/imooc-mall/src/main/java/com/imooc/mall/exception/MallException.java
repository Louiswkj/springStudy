package com.imooc.mall.exception;

import lombok.Getter;

/**
 * @author liuliang
 * 2021/5/31
 * 统一异常处理
 */
@Getter
public class MallException extends RuntimeException {
    private final Integer code;
    private final String message;

    public MallException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public MallException(MallExceptionEnum mallExceptionEnum) {
        this(mallExceptionEnum.getCode(), mallExceptionEnum.getMessage());
    }
}
