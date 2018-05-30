package com.xz.fld.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

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
    @ApiModelProperty(name = "注册渠道", example = "1-Android 2-IOS")
    private byte registerChannel;
    private byte registerMode;
    private String invitUserId;
    private String terminalInfo;
    private String code;

    @ApiModelProperty(hidden = true)
    private String appVersion;

    @ApiModelProperty(hidden = true)
    private String channelId;

    @ApiModelProperty(hidden = true)
    private String deviceId;

    @ApiModelProperty(hidden = true)
    private String deviceModel;

    @ApiModelProperty(hidden = true)
    private String osVersion;

    @ApiModelProperty(hidden = true)
    private String platform;

    @ApiModelProperty(hidden = true)
    private String timeStamp;
}
