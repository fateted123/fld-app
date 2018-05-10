package com.xz.fld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvitDTO {

    private Integer id;

    private String invitUserId;

    private String userId;

    private String invitName;

    private String invitMobile;

    private String regtime;

    private String regChannel;
}
