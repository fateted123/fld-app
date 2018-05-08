package com.xz.fld.domain;

import java.util.Date;

public class Invit {
    private String invitUserId;

    private String userId;

    private String invitName;

    private String invitMobile;

    private Date regtime;

    private Byte regChannel;

    public String getInvitUserId() {
        return invitUserId;
    }

    public void setInvitUserId(String invitUserId) {
        this.invitUserId = invitUserId == null ? null : invitUserId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getInvitName() {
        return invitName;
    }

    public void setInvitName(String invitName) {
        this.invitName = invitName == null ? null : invitName.trim();
    }

    public String getInvitMobile() {
        return invitMobile;
    }

    public void setInvitMobile(String invitMobile) {
        this.invitMobile = invitMobile == null ? null : invitMobile.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public Byte getRegChannel() {
        return regChannel;
    }

    public void setRegChannel(Byte regChannel) {
        this.regChannel = regChannel;
    }
}