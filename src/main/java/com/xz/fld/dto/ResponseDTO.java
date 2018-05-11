package com.xz.fld.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

    @ApiModelProperty(name = "返回信息载体", example = "{}|[]")
    private Object data;

    @ApiModelProperty(name = "返回码", example = "1000-成功 5000-重新登录 9999-异常")
    private int code = 1000;

    @ApiModelProperty(name = "错误信息", example = "用户名或者密码错误")
    private String message;

    private ResponseDTO() {

    }

    private ResponseDTO(int code, String message, Object data) {
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public static ResponseDTO success() {
        return new ResponseDTO(1000, null, null);
    }

    public static ResponseDTO success(Object data) {
        return new ResponseDTO(1000, null, data);
    }

    public static ResponseDTO failed(String message) {
        return new ResponseDTO(9999, message, null);
    }

    public static ResponseDTO login(String message) {
        return new ResponseDTO(5000, message, null);
    }

    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
