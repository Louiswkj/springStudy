package com.imooc.mall.common;

import com.imooc.mall.exception.MallExceptionEnum;

/**
 * @author liuliang
 * 2021/5/29
 * 通用返回对象
 */
public class ApiRestResponse<T> {
    private Integer status;
    private String message;
    private T data;


    private static final int OK_CODE = 10000;
    private static final String OK_MESSAGE = "success";


    public ApiRestResponse(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiRestResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


    public ApiRestResponse() {
        this(OK_CODE, OK_MESSAGE);
    }

    public static <T> ApiRestResponse<T> success() {
        return new ApiRestResponse<>();
    }

    public static <T> ApiRestResponse<T> success(T result) {
        ApiRestResponse<T> apiRestResponse = new ApiRestResponse<>();
        apiRestResponse.setData(result);
        return apiRestResponse;
    }

    public static <T> ApiRestResponse<T> error(Integer code, String message) {
        return new ApiRestResponse<>(code, message);
    }

    public static <T> ApiRestResponse<T> error(MallExceptionEnum mallExceptionEnum) {
        return new ApiRestResponse<>(mallExceptionEnum.getCode(), mallExceptionEnum.getMessage());
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiRestResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
