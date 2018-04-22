package com.xz.fld.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 手机终端注册信息
 */
@Getter
@Setter
public class UserRegister4PhoneDTO implements Serializable {

    private String phone;
    private String pwd;
    private String email;
    private byte registerChannel;
    private byte registerMode;
    private String invitUserId;
    private String terminalInfo;
    private String code;

}
