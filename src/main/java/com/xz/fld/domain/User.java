package com.xz.fld.domain;

import java.util.Date;

public class User {
    private String userId;

    private String phone;

    private String email;

    private String pwd;

    private Byte state;

    private Date openTime;

    private Date closeTime;

    private Date updateTime;

    private Date lastModifyPwdTime;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String pwdLevel;

    private Byte defaultRegisterState;

    private Byte registerChannel;

    private Byte registerMode;

    private String invitUserId;

    private String terminalInfo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastModifyPwdTime() {
        return lastModifyPwdTime;
    }

    public void setLastModifyPwdTime(Date lastModifyPwdTime) {
        this.lastModifyPwdTime = lastModifyPwdTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getPwdLevel() {
        return pwdLevel;
    }

    public void setPwdLevel(String pwdLevel) {
        this.pwdLevel = pwdLevel == null ? null : pwdLevel.trim();
    }

    public Byte getDefaultRegisterState() {
        return defaultRegisterState;
    }

    public void setDefaultRegisterState(Byte defaultRegisterState) {
        this.defaultRegisterState = defaultRegisterState;
    }

    public Byte getRegisterChannel() {
        return registerChannel;
    }

    public void setRegisterChannel(Byte registerChannel) {
        this.registerChannel = registerChannel;
    }

    public Byte getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(Byte registerMode) {
        this.registerMode = registerMode;
    }

    public String getInvitUserId() {
        return invitUserId;
    }

    public void setInvitUserId(String invitUserId) {
        this.invitUserId = invitUserId == null ? null : invitUserId.trim();
    }

    public String getTerminalInfo() {
        return terminalInfo;
    }

    public void setTerminalInfo(String terminalInfo) {
        this.terminalInfo = terminalInfo == null ? null : terminalInfo.trim();
    }
}